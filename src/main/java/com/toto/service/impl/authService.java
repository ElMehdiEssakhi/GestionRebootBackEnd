package com.toto.service.impl;

import com.toto.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface authService {
    User getUserByEmail(String email);
    Boolean checkPassword(User user, String password);
}
