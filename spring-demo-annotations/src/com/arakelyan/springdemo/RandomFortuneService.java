package com.arakelyan.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] fortunesArray = {
        "First fortune given",
        "Second fortune given",
        "Third fortune given"
    };

    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(fortunesArray.length);
        return fortunesArray[index];

    }
}
