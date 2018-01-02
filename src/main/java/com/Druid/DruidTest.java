package com.Druid;

import com.alibaba.druid.filter.config.ConfigTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * druid 加密解密：私钥加密，公钥解密
 * Created by Think on 2017/12/26.
 */
public class DruidTest {
    private static Logger logger = LoggerFactory.getLogger(DruidTest.class);

    public static void main(String[] args) {
        String password = "123qweQWE";
        druidEncryption(password);

        String password_ = "LLIbTJ+yM0moLICsNFTp9Qe4JDiffnSaqlblZzrItRt6WXp+whtwPDun2fcdFJ7GSed6o+190JlN3ZFesmQlyw==";
        String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIWwZGP9fzlCK1NUFkD5F3DmCTao5HkLyqD6E1WixjHsYK3lIZJ/ij+a4s0UcM5KOuqGED5D0AoLW77y4RfXUuUCAwEAAQ==";
        druidDecrypt(password_, publickey);
    }

    /**
     * druid 加密
     *
     * @param password
     */
    public static void druidEncryption(String password) {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            //私钥
            String privateKey = keyPair[0];
            //公钥
            String publicKey = keyPair[1];
            //用私钥加密后的密文
            password = ConfigTools.encrypt(privateKey, password);
            logger.info("privateKey:" + privateKey);
            logger.info("publicKey:" + publicKey);
            logger.info("password:" + password);
        } catch (Exception e) {
            logger.info("druid Encryption exception ,Exception " + e);
        }
    }

    /**
     * druid 解密
     *
     * @param password  密码
     * @param publickey 公钥解密
     */
    public static void druidDecrypt(String password, String publickey) {
        try {
            logger.info("password : " + ConfigTools.decrypt(publickey, password));
        } catch (Exception e) {
            logger.info("druid decrypt exception ,Exception " + e);
        }
    }
}
