package com.arakelyan.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.arakelyan.aop.dao.*.*(..))")
    private void pointcutForDAOPackage() {

    }

    @Before("pointcutForDAOPackage()")
    public void pointcutExampleOne() {
        System.out.println(getClass() + " ===> This is FIRST advice from pointcut declared to DAO package <=== ");
    }

    @Before("pointcutForDAOPackage()")
    public void pointcutExampleTwo() {
        System.out.println(getClass() + " ===> This is SECOND advice from pointcut declared to DAO package <=== ");
    }

}
