package com.uncle.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @Desc: 时间工具类
 * @author: uncle
 * @date: 2018/10/12
 */
public abstract class DateUtils {

    public static final String YYYY = "yyyy";
    public static final String YYYYMM = "yyyyMM";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final SimpleDateFormat DT_YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
    public static final SimpleDateFormat DT_YYYYMMDDHHMMSS = new SimpleDateFormat(YYYYMMDDHHMMSS);
    public static final SimpleDateFormat DT_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
    public static final SimpleDateFormat DT_YYYYMMDD = new SimpleDateFormat(YYYYMMDD);



    public static String getCurrentDateTime(){
        Date date = new Date();
        return  DT_YYYY_MM_DD_HH_MM_SS.format(date);
    }

    public static String getCurrentDate(){
        Date date = new Date();
        return  DT_YYYY_MM_DD.format(date);
    }


    public static String getCurrentDate(String pattern){
        return getDate(new Date(), pattern);
    }


    public static String getDate(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return  sdf.format(date);
    }


    public static long getTimeStamp() {
        return new Date().getTime();
    }



    public static Date toDate(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date parse = sdf.parse(str);
        return parse;
    }


    public static Date toDate(String str) throws ParseException {
        return DT_YYYY_MM_DD_HH_MM_SS.parse(str);
    }



    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtils.getCurrentDateTime());
        System.out.println(DateUtils.getCurrentDate());
        System.out.println(DateUtils.getCurrentDate(YYYY_MM));
        System.out.println(DateUtils.toDate(DateUtils.getCurrentDateTime()));
    }

}
