package com.example.rbc.service;

import com.example.rbc.model.User;

public interface UserService {

    void save(User user);
    User findByUsername(String username);
}
