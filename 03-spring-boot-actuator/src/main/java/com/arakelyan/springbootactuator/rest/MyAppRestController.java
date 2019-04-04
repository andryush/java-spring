package com.arakelyan.springbootactuator.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyAppRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${coach.age}")
    private String coachAge;

    @GetMapping("/v1")
    public String sayHello() {
        return "Hello world " + coachName + " " + coachAge;
    }

}
