package com.arakelyan.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(3)
public class MyCloudLogAspect {


    @Before("com.arakelyan.aop.aspect.AopExpressions.pointcutForDAOPackage()")
    public void loggingToCloud() {
        System.out.println(getClass() + "===> Advice @Before from Cloud logging");
    }
}
