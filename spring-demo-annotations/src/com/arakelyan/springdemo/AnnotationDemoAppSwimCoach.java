package com.arakelyan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoAppSwimCoach {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach swimCoach = context.getBean("swimCoach", Coach.class);

        System.out.println(swimCoach.getDailyWorkout());

        System.out.println(swimCoach.getDailyFortune());

    }

}
