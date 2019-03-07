package com.arakelyan.springdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(MyLoggerConfig.class, TestConfig.class);

        Coach theCoach = context.getBean("testCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        context.close();

    }

}
