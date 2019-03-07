package com.arakelyan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class HelloSpringApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("file:applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        Coach myCricketCoach = context.getBean("myCricketCoach", Coach.class);

        System.out.println(myCricketCoach.getDailyFortune());
        System.out.println(myCricketCoach.getDailyWorkout());

        context.close();

    }

}
