package com.linktones.digital_teach.controller;

import com.linktones.digital_teach.utils.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(HttpServletResponse response){
        CookieUtil.clearCookie(response,"token");

        return "redirect:/";
    }
}
