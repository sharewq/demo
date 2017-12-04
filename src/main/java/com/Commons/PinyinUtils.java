package com.Commons;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Think on 2017/11/2.
 */
public class PinyinUtils {
    private static Logger logger = LoggerFactory.getLogger(PinyinUtils.class);


    public PinyinUtils() {
    }

    /**
     * 获取汉子拼音
     *
     * @param str
     * @return
     */
    public static String toPingYin(String str) {
        char[] t1 = str.toCharArray();
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;

        try {
            for (int i = 0; i < t0; ++i) {
                if (StringUtils.containsChineseChar(Character.toString(t1[i]))) {
                    String[] t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 = t4 + t2[0];
                } else {
                    t4 = t4 + Character.toString(t1[i]);
                }
            }
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination var7) {
            logger.error("获取汉子拼音异常， Excption = " + var7);
        }
        return t4;
    }

    /**
     * 获取汉子拼音头
     *
     * @param str
     * @return
     */
    public static String toPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); ++j) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert = convert + pinyinArray[0].charAt(0);
            } else {
                convert = convert + word;
            }
        }

        return convert;
    }
}
