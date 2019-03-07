package com.arakelyan.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class NewRandomFortuneService implements FortuneService {

    @Value("${fortune.1}")
    private String first;

    @Value("${fortune.2}")
    private String second;

    @Value("${fortune.3}")
    private String third;

    @Value("${fortune.4}")
    private String fourth;

    @Value("${fortune.5}")
    private String fifth;

    private String[] fortunesArray = new String[5];

    private Random myRandom = new Random();

    @PostConstruct
    private void doAssignment() {
        fortunesArray[0] = first;
        fortunesArray[1] = second;
        fortunesArray[2] = third;
        fortunesArray[3] = fourth;
        fortunesArray[4] = fifth;
    }

    @Override
    public String getFortune() {

        int index = myRandom.nextInt(fortunesArray.length);
        return fortunesArray[index];
    }

}
