package com.herohuang.framework.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    /**
     * 字符器分隔符
     *
     * @param str
     * @return
     */
    public static final String SEPARATOR = String.valueOf((char) 29);

    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 分割固定格式的字符串
     */
    public static String[] splitString(String str, String seprator) {
        return StringUtils.splitByWholeSeparator(str, seprator);
    }
}
