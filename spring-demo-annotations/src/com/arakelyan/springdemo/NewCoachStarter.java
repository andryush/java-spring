package com.arakelyan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NewCoachStarter {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext newContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach newCoach = newContext.getBean("newCoach", Coach.class);

        System.out.println(newCoach.getDailyWorkout());
        System.out.println(newCoach.getDailyFortune());

        newContext.close();

    }

}
