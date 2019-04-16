package com.uncle.common.util;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesHolder {

    private Properties p = new Properties();
    private String path;

    public PropertiesHolder(String path) {
        this.path = path;
        this.init();
    }

    private  void init() {
        //转换成流
//        InputStream inputStream = PropertiesHolder.class.getClassLoader().getResourceAsStream(path);

        try {
            InputStream inputStream = new FileInputStream(path);
            //从输入流中读取属性列表（键和元素对）
            p.load(new InputStreamReader(inputStream, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过key获取value
     * @param key
     * @return
     */
    public  String get(String key) {
        return p.getProperty(key);
    }

    /**
     * 修改或者新增key
     * @param key
     * @param value
     */
    public  void update(String key, String value) {
        p.setProperty(key, value);
        Writer oFile = null;
        try {
             oFile = new FileWriter(path);
            p.store(oFile, "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过key删除value
     * @param key
     */
    public  void delete(String key) {
        p.remove(key);
        FileOutputStream oFile = null;
        try {
            oFile = new FileOutputStream(path);
            p.store(oFile, "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 循环所有key value
     */
    public  void list() {
        Enumeration en = p.propertyNames(); //得到配置文件的名字
        while(en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = p.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }
    }


}
