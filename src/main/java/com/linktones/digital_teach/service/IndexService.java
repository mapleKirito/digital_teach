package com.linktones.digital_teach.service;

import com.linktones.digital_teach.entity.User;

public interface IndexService {

    User getUser(String token);
}
