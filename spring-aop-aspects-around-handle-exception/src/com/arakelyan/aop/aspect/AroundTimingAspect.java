package com.arakelyan.aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AroundTimingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.arakelyan.aop.service.TrafficFortuneService.get*(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n===>>>>>EXECUTING AROUND ON METHOD>>> " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now, let's execute the method
        Object result = null;
        try {
                result =proceedingJoinPoint.proceed();
        }
        catch (Exception exc) {
            //log the exception
            myLogger.warning(exc.getMessage());

            //give user a custom message
            result = "There is small errors but don't worry<<<YOUR AOP>>>";
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;
        myLogger.info("\n======> Duration is " + duration / 1000.0 + " seconds");

        return result;

    }

}
