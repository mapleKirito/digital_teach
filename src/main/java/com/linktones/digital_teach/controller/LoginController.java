package com.linktones.digital_teach.controller;


import com.linktones.digital_teach.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String login(){
        return "login";
    }


    @PostMapping
    public String admin(HttpServletResponse response,
                        @RequestParam("account")String account,
                        @RequestParam("password")String password,
                        Model model){
        Cookie cookie = loginService.setLoginToken(account, password);
        if(cookie==null){
            model.addAttribute("error","登陆失败，用户名或密码错误");
            return "login";
        }
        response.addCookie(cookie);

        return "redirect:/";
    }
}
