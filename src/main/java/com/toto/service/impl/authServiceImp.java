package com.toto.service.impl;

import com.toto.entity.User;
import com.toto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class authServiceImp implements authService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean checkPassword(User user, String password) {
        return (user.getPassword().equals(password));
    }
}
