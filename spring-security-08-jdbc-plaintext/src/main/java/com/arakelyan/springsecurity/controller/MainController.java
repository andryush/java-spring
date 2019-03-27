package com.arakelyan.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeadresPage() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showAdminsPage() {
        return "systems";
    }

}
