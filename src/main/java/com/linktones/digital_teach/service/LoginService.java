package com.linktones.digital_teach.service;

import javax.servlet.http.Cookie;

public interface LoginService {
    Cookie setLoginToken(String account, String password);
}
