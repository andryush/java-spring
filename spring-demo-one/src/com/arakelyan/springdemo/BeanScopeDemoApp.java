package com.arakelyan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("file:beanScopeApplicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        boolean result = (theCoach == alphaCoach);

        System.out.println("Pointing to the same object: " + result);

        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("memory location for alphaCoach: " + alphaCoach);

        context.close();

    }

}
