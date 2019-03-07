package com.arakelyan.springdemo;

public class TestCoach implements Coach {

    private FortuneService newFortuneService;

    public TestCoach() {
        System.out.println("Inside default constructor");
    }

    public FortuneService getNewFortuneService() {
        return newFortuneService;
    }

    public void setNewFortuneService(FortuneService newFortuneService) {
        this.newFortuneService = newFortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "getDailyWorkout - text from that method";
    }

    @Override
    public String getDailyFortune() {
        return "getDailyfortune + getFortune" + newFortuneService.getFortune();
    }
}
