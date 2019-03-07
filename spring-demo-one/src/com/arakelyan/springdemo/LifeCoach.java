package com.arakelyan.springdemo;

public class LifeCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run Vasya Run";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
