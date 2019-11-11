package com.linktones.digital_teach.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 */

public class CookieUtil {
    public static Cookie getCookie(HttpServletRequest request,String name){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(name)){
                return cookie;
            }

        }
        return null;
    }

    public static void setCookie(HttpServletResponse response,String name,String value){
        Cookie cookie = new Cookie(name, value);
        response.addCookie(cookie);
    }

    public static void clearCookie(HttpServletResponse response,String name){
        Cookie cookie = new Cookie(name,null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
