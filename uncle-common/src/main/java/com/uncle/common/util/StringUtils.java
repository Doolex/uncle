package com.uncle.common.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {


    public static boolean isNull(String str) {
      return !notNull(str);
    }


    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return isNull(str) || str.trim().isEmpty();
    }




    /**
     * @param bytes
     * @return
     */
    public static byte[] decodeBase64(final byte[] bytes) {
        return Base64.decodeBase64(bytes);
    }


    public static boolean hasText(String str) {
        return !isBlank(str);
    }

    public static boolean notNull(Object record) {
        return record != null;
    }

    /**
     * @param
     * @return
     */
    public static String decodeBase64StrToStr(String base64String) {
        byte[] base64Bytes = base64String.getBytes();
        byte[] transByue = Base64.decodeBase64(base64Bytes);
        String str = null;
        try {
            str = new String(transByue);
        } catch (Exception e) {
            str = new String(transByue);
        }

        return str;
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否中文乱码
     *
     * @param strName
     * @return
     */
    public static boolean isMessyCode(String strName) {
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = 0;
        float count = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c)) {
                if (!isChinese(c)) {
                    count = count + 1;
                }
                chLength++;
            }
        }
        float result = count / chLength;
        if (result > 0.4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param
     * @return
     */
    public static byte[] decodeBase64StrToByte(String base64String) {
        byte[] base64Bytes = base64String.getBytes();
        return Base64.decodeBase64(base64Bytes);
    }

    /**
     * 二进制数据编码为BASE64字符串
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(final byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }


    /**
     * 截取 字符串，不够以0 补充
     *
     * @param str   字符串
     * @param start 截取开始位置(包含)
     * @param end   截取结束位置(不包含)
     * @return
     */
    public static String substring(String str, int start, int end) {
        int len = 0;
        if (isNull(str)) {
            len = str.length();
        }

        if (len < end) {// 长度不够，补充 0
            return append(str, len, end).substring(start, end);
        } else {
            return str.substring(start, end);
        }

    }

    private static String append(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = start; i < end; i++) {
            sb.append("0");
        }
        return sb.toString();
    }




    public static void main(String[] args) {
       String str = "\\\\  ";
        System.out.println(StringUtils.isBlank(str));
        System.out.println(StringUtils.isNull(str));
        System.out.println(StringUtils.hasText(str));
    }


}
