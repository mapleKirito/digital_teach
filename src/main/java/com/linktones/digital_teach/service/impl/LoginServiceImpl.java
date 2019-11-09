package com.linktones.digital_teach.service.impl;

import com.linktones.digital_teach.entity.User;
import com.linktones.digital_teach.mapper.UserMapper;
import com.linktones.digital_teach.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Cookie setLoginToken(String account, String password) {
        User userValue = new User();
        userValue.setAccount(account);
        userValue.setPassword(password);
        User user=userMapper.getUser(userValue);
        if(user!=null){
            //创建token，更新user表，同时组建带token的cookie
            String token= UUID.randomUUID().toString();
            user.setToken(token);
            userMapper.updateToken(user);
            Cookie cookie=new Cookie("token",token);
            return cookie;
        }
        return null;
    }
}
