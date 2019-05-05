package com.example.rbc.controller;

import com.example.rbc.model.User;
import com.example.rbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class UserProfileController {


    private UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showMyProfile() {


        return "myProfile";
    }

/*    @GetMapping("/changePassword")
    public String showChangePassword(Principal principal, Model model) {

        String username = principal.getName();

        User mainUser = userService.findByUsername(username);

        model.addAttribute("mainUser", mainUser);

        return "changePasswordForm";
    }*/



}
