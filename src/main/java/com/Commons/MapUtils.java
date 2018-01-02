package com.Commons;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangqiang
 * @date 2017/1/2
 */
public class MapUtils {
    
    /**
     * 将map中的key下划线转成驼峰
     *
     * @param map
     */
    public static Map keyUnderlineTheHump(Map map) {
        Map result = new HashMap();
        map.forEach((key, val) -> {
            String lowerCase = key.toString().toLowerCase();
            result.put(toCamelCase(lowerCase), val);
        });
        return result;
    }
    
    /**
     * 将map中的key转成小写
     *
     * @param map
     */
    public static Map keyLowerCase(Map map){
        Map result = new HashMap();
        map.forEach((key, val) -> {
            String lowerCase = key.toString().toLowerCase();
            result.put(lowerCase, val);
        });
        return result;
    }
    
    
    private static String toCamelCase(CharSequence name) {
        if (null == name) {
            return null;
        }
        String name2 = name.toString();
        if (name2.contains("_")) {
            name2 = name2.toLowerCase();
            
            StringBuilder sb = new StringBuilder(name2.length());
            boolean upperCase = false;
            for (int i = 0; i < name2.length(); i++) {
                char c = name2.charAt(i);
                
                if (c == '_') {
                    upperCase = true;
                } else if (upperCase) {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        } else {
            return name2;
        }
    }
    
}
