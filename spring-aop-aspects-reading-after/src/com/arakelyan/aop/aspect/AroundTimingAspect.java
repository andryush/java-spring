package com.arakelyan.aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundTimingAspect {

    @Around("execution(* com.arakelyan.aop.service.TrafficFortuneService.get*(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===>>>>>EXECUTING AROUND ON METHOD>>> " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now, let's execute the method
        Object result = proceedingJoinPoint.proceed();

        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;
        System.out.println("\n======> Duration is " + duration / 1000.0 + " seconds");

        return result;

    }

}
