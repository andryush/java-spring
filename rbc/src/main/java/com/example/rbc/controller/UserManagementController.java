package com.example.rbc.controller;

import com.example.rbc.model.User;
import com.example.rbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userManagement")
public class UserManagementController {

    private final UserService userService;

    @Autowired
    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {

        List<User> regUsersForm = userService.getAll();

        model.addAttribute("regUsersForm", regUsersForm);

        return "showUsers";
    }

}
