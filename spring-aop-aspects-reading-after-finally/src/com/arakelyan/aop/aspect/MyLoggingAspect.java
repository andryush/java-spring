package com.arakelyan.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    @Before("com.arakelyan.aop.aspect.AopExpressions.pointcutForDAOPackage()")
    public void logging(JoinPoint joinPoint) {
        System.out.println(getClass() + "===> Advice @Before from logging");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method:> " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);
        }

    }

}
