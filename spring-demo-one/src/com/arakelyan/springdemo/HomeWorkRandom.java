package com.arakelyan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeWorkRandom {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("file:applicationContext.xml");

        Coach testCoach = context.getBean("testCoach", Coach.class);

        System.out.println(testCoach.getDailyWorkout());
        System.out.println(testCoach.getDailyFortune());

        context.close();

    }


}
