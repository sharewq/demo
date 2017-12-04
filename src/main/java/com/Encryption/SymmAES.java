package com.Encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

/**
 * 加密--AES
 * Created by Think on 2017/11/14.
 */
public class SymmAES {
    private static final String AES = "AES";
    private static final String UTF8 = "UTF-8";
    static KeyGenerator kgen = null;

    static {
        try {
            kgen = KeyGenerator.getInstance(AES);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 加密 -- AES
     *
     * @param content:
     * @param password:
     */
    private static String encrypt(String content, String password) {
        try {
            // 使用静态代码块来生成KeyGenerator对象
            //KeyGenerator kgen = KeyGenerator.getInstance(AES);
            // 使用128 位
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] encodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(encodeFormat, AES);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(AES);
            // 加密内容进行编码
            byte[] byteContent = content.getBytes(UTF8);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 正式执行加密操作
            byte[] result = cipher.doFinal(byteContent);

            //把二进制转为为十六进制字符
            String resultStr = parseByte2HexStr(result);
            return resultStr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密 -- AES
     *
     * @param content:
     * @param password:
     */
    private static byte[] decrypt(String content, String password) {
        try {
            //先把十六进制字符转化为二进制
            byte[] contentByte = parseHexStr2Byte(content);
            // 使用静态代码块来生成KeyGenerator对象
            //KeyGenerator kgen = KeyGenerator.getInstance(AES);
            // 使用128 位
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] encodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(encodeFormat, AES);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(AES);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, key);

            // 正式执行解密操作
            byte[] result = cipher.doFinal(contentByte);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 对加密内容进行转换
     * 二进制--》十六进制转化
     *
     * @param buf
     * @return
     */
    private static String parseByte2HexStr(byte buf[]) {
        if (buf == null || buf.length < 1) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 十六进制--》二进制转化
     *
     * @param hexStr
     * @return
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr == null || hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        long begin = new Date().getTime();
        String content = "使用 'ASE' 加密算法加密数据内容。";
        String password = "12345678dd";
        // 加密
        System.out.println("加密前：" + content);
        System.out.println("加密公钥：" + password);
        String encryptStr = encrypt(content, password);
        System.out.println("加密后：" + encryptStr);
        // 解密
        byte[] decryptResult = decrypt(encryptStr, password);
        // 解密内容进行解码
        String result = new String(decryptResult, UTF8);
        System.out.println("解密后：" + result);
        System.out.println("解密公钥：" + password);
        long end = new Date().getTime();
        System.out.println("用时: " + (end - begin));
    }
}
