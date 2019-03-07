package com.arakelyan.springdemo;

public class BaseBallCoach implements Coach {

    private FortuneService fortuneService;

    public BaseBallCoach() {

    }

    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
