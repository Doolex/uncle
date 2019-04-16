package com.uncle.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 /**
 *
 * @Desc: cookie工具
 * @author: uncle
 * @date: 2018/10/12
 */
public class CookieUtils {

    private static final String DEFAULT_PATH = "/";
    private static final int DEFAULT_AGE = 60 * 60 * 24 * 30;//一个月

    public static void add(HttpServletResponse response, String name, String value) {
        add(response, name, value, DEFAULT_AGE);
    }

    public static void add(HttpServletResponse response, String name, String value, Integer maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(DEFAULT_PATH);
        if (maxAge != null) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    public static void remove(HttpServletResponse response, String name) {
        add(response, name, null, -1);
    }

    public static String get(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
