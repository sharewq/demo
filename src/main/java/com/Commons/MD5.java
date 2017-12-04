package com.Commons;


//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Think on 2017/11/14.
 */
public final class MD5 {
    public MD5() {
    }

    public static String encode(String string) {
        String encode = defaultEncode(string);
        StringBuilder sb = new StringBuilder();
        sb.append("125639751@qq.com");
        int i = 0;

        for (int length = encode.length() / 2; i < length; ++i) {
            sb.append(encode.charAt(i * 2 + 1));
            sb.append(encode.charAt(i * 2));
        }

        return defaultEncode(sb.toString());
    }

    public static String defaultEncode(String string) {
        StringBuilder sb = new StringBuilder(32);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashValue = md.digest(string.getBytes());

            for (int i = 0; i < hashValue.length; ++i) {
                sb.append(Integer.toHexString((hashValue[i] & 240) >> 4));
                sb.append(Integer.toHexString(hashValue[i] & 15));
            }
        } catch (NoSuchAlgorithmException var5) {
            ;
        }

        return sb.toString();
    }

    public static byte[] encrypt(String data) throws IOException {
        return encrypt(data.getBytes("utf-8"));
    }

    public static byte[] encrypt(byte[] data) throws IOException {
        Object var1 = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(data);
            return bytes;
        } catch (GeneralSecurityException var3) {
            throw new IOException(var3.toString());
        }
    }

    public static byte[] encryptHMAC(String data, String secret) throws IOException {
        Object var2 = null;

        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            byte[] bytes = mac.doFinal(data.getBytes("UTF-8"));
            return bytes;
        } catch (GeneralSecurityException var5) {
            throw new IOException(var5.toString());
        }
    }

    public String getMd5ByFile(File file) {
        String value = null;
        FileInputStream in = null;

        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException var17) {
            var17.printStackTrace();
        }

        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception var16) {
            var16.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException var15) {
                    var15.printStackTrace();
                }
            }

        }

        return value;
    }

    public void writeStringToFile(String filePath, String md5) {
        try {
            File file = new File(filePath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println(md5);
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        }

    }
}
