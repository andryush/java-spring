package com.arakelyan.springdemo;

public class TestFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "JUST FOR TEST FORTUNE SERVICE";
    }

}
