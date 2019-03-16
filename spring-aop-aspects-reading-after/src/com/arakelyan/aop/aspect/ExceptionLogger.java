package com.arakelyan.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLogger {

    @AfterThrowing(
            value = "com.arakelyan.aop.aspect.AopExpressions.pointcutForFindMethods()",
            throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterThrowing method: " + method);

        //log the exception
        System.out.println("\n====>>>> The exception is:>>> " + exc);

    }

}
