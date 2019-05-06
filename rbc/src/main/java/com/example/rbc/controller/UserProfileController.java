package com.example.rbc.controller;

import com.example.rbc.model.User;
import com.example.rbc.service.UserService;
import com.example.rbc.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class UserProfileController {


    private final UserService userService;
    private final PasswordValidator passwordValidator;

    @Autowired
    public UserProfileController(UserService userService, PasswordValidator passwordValidator) {
        this.userService = userService;
        this.passwordValidator=passwordValidator;
    }

    @GetMapping
    public String showMyProfile() {


        return "myProfile";
    }

    @GetMapping("/changePassword")
    public String showChangePassword(Principal principal, Model model) {

        String username = principal.getName();

        System.out.println("DEBUG - PRINCIPAL USERNAME - " + username);

        User userPasswordForm = userService.findByUsername(username);

        model.addAttribute("userPasswordForm", userPasswordForm);

        return "changePasswordForm";
    }

    @PostMapping("/changePassword")
    public String updatePassword(@ModelAttribute("userPasswordForm") User userPasswordForm, BindingResult bindingResult) {

        passwordValidator.validate(userPasswordForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "changePasswordForm";
        }

        userService.savePassword(userPasswordForm);

        return "redirect:/profile";
    }

}
