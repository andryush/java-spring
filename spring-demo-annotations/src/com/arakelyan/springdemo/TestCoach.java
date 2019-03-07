package com.arakelyan.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class TestCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public TestCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "JUST FOR TEST WORKOUT " + "EMAIL: " + email;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune() + " TEAM " + team;
    }

}
