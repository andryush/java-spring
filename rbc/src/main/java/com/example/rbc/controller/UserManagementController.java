package com.example.rbc.controller;

import com.example.rbc.model.User;
import com.example.rbc.service.UserService;
import com.example.rbc.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userManagement")
public class UserManagementController {

    private final UserService userService;
    private final PasswordValidator passwordValidator;

    @Autowired
    public UserManagementController(UserService userService, PasswordValidator passwordValidator) {
        this.userService = userService;
        this.passwordValidator = passwordValidator;
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {

        List<User> regUsersForm = userService.getAll();

        model.addAttribute("regUsersForm", regUsersForm);

        return "showUsers";
    }

    @GetMapping("/showUserFormForPassword")
    public String showUserFormForPassword(@RequestParam("userId") Long id, Model model) {

        User regUserForm = userService.getById(id);

        model.addAttribute("regUserForm", regUserForm);

        return "showUserFormForPassword";
    }

    @GetMapping("/showUserFormForRole")
    public String showUserFormForRole(@RequestParam("userId") Long id, Model model) {

        User regUserForm = userService.getById(id);

        model.addAttribute("regUserForm", regUserForm);

        return "showUserFormForRole";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("regUserForm") User regUserForm, BindingResult bindingResult) {

        passwordValidator.validate(regUserForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "showUserFormForPassword";
        }

        userService.savePassword(regUserForm);

        return "redirect:/userManagement/showUsers";
    }

    @PostMapping("/saveRole")
    public String saveRole(@ModelAttribute("regUserForm") User regUserForm) {

        userService.saveRole(regUserForm);

        return "redirect:/userManagement/showUsers";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") Long id) {

        userService.delete(id);

        return "redirect:/userManagement/showUsers";
    }

}
