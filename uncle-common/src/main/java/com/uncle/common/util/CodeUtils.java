package com.uncle.common.util;

import java.util.UUID;

/**
 *
 * @Desc: 编码工具类
 * @author: uncle
 * @date: 2018/10/12
 */
public final class CodeUtils {

    /**
     * 获取32位UUID
     * @return
     */
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
