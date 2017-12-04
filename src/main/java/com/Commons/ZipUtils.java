package com.Commons;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by Think on 2017/11/2.
 */
public class ZipUtils {
    /**
     * 压缩文件-由于out要在递归调用外,所以封装一个方法用来
     * 调用ZipFiles(ZipOutputStream out,String path,File... srcFiles)
     *
     * @param zip      目标文件（路径+名称：c:/test.zip）
     * @param path     为压缩缩文件添加子级目录(c:/path/test.zip)
     * @param srcFiles 源文件（一个或多个）
     * @throws IOException
     */
    public static void CompressZipFiles(File zip, String path, File... srcFiles) {
        ZipOutputStream out = null;
        try {
            path = addSuffix(path);
            out = new ZipOutputStream(new FileOutputStream(zip));
            ZipUtils.ZipFiles(out, path, srcFiles);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("*****************压缩完毕*******************");
    }

    /**
     * 压缩文件-File
     *
     * @param out      输出文件流
     * @param path     为压缩缩文件添加子级目录
     * @param srcFiles 源文件（一个或多个）
     */
    private static void ZipFiles(ZipOutputStream out, String path, File... srcFiles) {
        byte[] buf = new byte[1024];
        try {
            for (int i = 0; i < srcFiles.length; i++) {
                if (srcFiles[i].isDirectory()) {
                    File[] files = srcFiles[i].listFiles();
                    String srcPath = srcFiles[i].getName();
                    srcPath = srcPath.replaceAll("\\*", "/");
                    if (!srcPath.endsWith("/")) {
                        srcPath += "/";
                    }
                    out.putNextEntry(new ZipEntry(path + srcPath));
                    ZipFiles(out, path + srcPath, files);
                } else {
                    FileInputStream in = new FileInputStream(srcFiles[i]);
                    System.out.println(path + srcFiles[i].getName());
                    out.putNextEntry(new ZipEntry(path + srcFiles[i].getName()));
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    out.closeEntry();
                    if (null != in) {
                        in.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 解压到指定目录
     *
     * @param zipPath 解压文件路径
     * @param descDir
     * @author isea533
     */
    public static void UnpackZipFiles(String zipPath, String descDir) {
        try {
            descDir = addSuffix(descDir);
            unZipFiles(new File(zipPath), descDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 为文件目录添加后缀（'/'）
     *
     * @param path 路径
     * @return String 返回值
     */
    private static String addSuffix(String path) {
        if (null == path) {
            path = "";
        }
        path = path.replaceAll("\\*", "/");
        if (!path.endsWith("/")) {
            path += "/";
        }
        return path;
    }


    public static String getFilePath(File file) {
        if (!file.exists() || file.length() == 0) {
            return "";
        }
        String path = file.getAbsolutePath();
        path = path.replaceAll("\\\\", "/");
        path = path.substring(0, path.lastIndexOf("."));
        return path;
    }

    /**
     * 解压文件到指定目录
     *
     * @param zipFile 压缩文件
     * @param descDir 解压文件路径
     * @author isea533
     */
    @SuppressWarnings("rawtypes")
    public static void unZipFiles(File zipFile, String descDir) {
        if (!zipFile.exists() || zipFile.length() == 0) {
            return;
        }
        if ("" == descDir || null == descDir) {
            descDir = getFilePath(zipFile);
        }
        descDir = addSuffix(descDir);
        File pathFile = new File(descDir);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        ZipFile zip = null;
        try {
            zip = new ZipFile(zipFile);
            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zip.getInputStream(entry);
                String outPath = (descDir + zipEntryName).replaceAll("\\*", "/");
                //判断路径是否存在,不存在则创建文件路径
                File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
                if (!file.exists()) {
                    file.mkdirs();
                }
                //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if (new File(outPath).isDirectory()) {
                    continue;
                }
                //输出文件路径信息
                System.out.println(outPath);
                OutputStream out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.flush();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("******************解压完毕********************");
    }

    /**
     * 判读系统是windows或者linux系统
     *
     * @return (-1:err, 0:init, 1:win, 2:lin)
     */
    public static int isWindowsOrLinux() {
        int flag = 0;
        try {
            String sysNmae = System.getProperties().getProperty("os.name");
            if (null != sysNmae && sysNmae.length() > 5) {
                sysNmae = sysNmae.substring(0, 5);
            }
            if (sysNmae.equalsIgnoreCase("Windo")) {
                flag = 1;
            } else {
                flag = 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = -1;
            return flag;
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        /**
         * 压缩文件
         */
        File[] files = new File[]{new File("C:/wq_using/工作日志"), new File("C:/wq_using/户籍信息.txt"), new File("C:/wq_using/迁出检验查询.txt")};
        File zip = new File("C:/wq_using/压缩.zip");
        CompressZipFiles(zip, "", files);

        /**
         * 解压文件
         */
        File zipFile = new File("C:/wq_using/压缩.zip");
        String path = "";
        unZipFiles(zipFile, path);

    }

}
