package com.linktones.digital_teach.service.impl;

import com.linktones.digital_teach.entity.User;
import com.linktones.digital_teach.mapper.UserMapper;
import com.linktones.digital_teach.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String token) {
        User user = userMapper.findByToken(token);
        user.setPassword("Private");
        return user;
    }
}
