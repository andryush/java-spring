package com.arakelyan.aop;

import com.arakelyan.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMAIN AROUND APP");

        System.out.println("Calling getFortune()");

        String data = trafficFortuneService.getFortune();

        System.out.println("My fortune is>>> " + data);

        System.out.println("Finished");

        context.close();
    }
}
