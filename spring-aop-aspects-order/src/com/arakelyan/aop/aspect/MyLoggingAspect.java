package com.arakelyan.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    @Before("com.arakelyan.aop.aspect.AopExpressions.pointcutForDAOPackage()")
    public void logging() {
        System.out.println(getClass() + "===> Advice @Before from logging");
    }

}
