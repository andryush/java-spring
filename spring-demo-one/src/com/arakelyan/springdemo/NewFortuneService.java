package com.arakelyan.springdemo;

import java.util.Random;

public class NewFortuneService implements FortuneService {

    private String[] fortuneArray = {
            "First random text",
            "Second random text",
            "Third random text"
    };

    private Random myRandom = new Random();


    @Override
    public String getFortune() {

        int index = myRandom.nextInt(fortuneArray.length);

        String randomFortune = fortuneArray[index];

        return randomFortune;
    }
}
