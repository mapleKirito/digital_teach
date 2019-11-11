package com.linktones.digital_teach.controller;

import com.linktones.digital_teach.entity.User;
import com.linktones.digital_teach.mapper.UserMapper;
import com.linktones.digital_teach.service.IndexService;
import com.linktones.digital_teach.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 首页Controller
 * 根据登陆条件跳转：
 * index--已登陆；login--未登录
 */

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/")
    public String index(HttpSession session,
                        HttpServletRequest request){
        Cookie cookie= CookieUtil.getCookie(request,"token");
        if(cookie!=null){
            String token=cookie.getValue();
            User user = indexService.getUser(token);
            if(user!=null){
                session.setAttribute("user",user);
                return "index";
            }
        }

        return "login";

    }
}
