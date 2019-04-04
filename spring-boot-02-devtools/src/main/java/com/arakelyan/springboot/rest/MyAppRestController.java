package com.arakelyan.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyAppRestController {

    @GetMapping("/v1")
    public String sayHello() {
        return "Hello world";
    }

}
