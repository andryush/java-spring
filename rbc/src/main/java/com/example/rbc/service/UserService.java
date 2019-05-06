package com.example.rbc.service;

import com.example.rbc.model.User;

import java.util.List;

public interface UserService {


    List<User> getAll();

    User getById(Long id);

    void save(User user);

    void saveRole(User user);

    void savePassword(User user);

    void delete(Long id);

    User findByUsername(String username);




}
