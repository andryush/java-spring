package com.arakelyan.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewCoach implements Coach {

    @Autowired
    @Qualifier("newRandomFortuneService")
    private FortuneService newRandomService;

    public NewCoach() {

    }

    public String getDailyWorkout() {
        return ">> NEW COACH: Work HARDER";
    }

    public String getDailyFortune() {
        return newRandomService.getFortune();
    }
}
