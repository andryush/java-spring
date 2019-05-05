package com.example.rbc.service.impl;

import com.example.rbc.model.Role;
import com.example.rbc.model.User;
import com.example.rbc.service.UserService;
import com.example.rbc.repository.RoleRepository;
import com.example.rbc.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();

        roles.add(roleRepository.getOne(2L));

        user.setRoles(roles);

        userRepository.save(user);

    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new RuntimeException("Did not find user id - " + id);
        }

        return user;

    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);

    }
}
