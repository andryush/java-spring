/*
package com.arakelyan.aop;

import com.arakelyan.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerMain {

    private static Logger myLogger =
            Logger.getLogger(AroundWithLoggerMain.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMAIN AROUND APP");

        myLogger.info("Calling getFortune()");

        boolean tripWire;
        String data = trafficFortuneService.getFortune(tripWire);

        myLogger.info("My fortune is>>> " + data);

        myLogger.info("Finished");

        context.close();
    }
}
*/
