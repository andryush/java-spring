package com.arakelyan.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAnalyticsAspect {

    @Before("com.arakelyan.aop.aspect.AopExpressions.pointcutForDAOPackage()")
    public void analytics() {
        System.out.println(getClass() + "===> Advice @Before from analytics");
    }

}
