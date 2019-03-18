package com.arakelyan.springdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declaration
    @Pointcut("execution(* com.arakelyan.springdemo.DAO.*.*(..))")
    public void pointcutForBeforeAdviceForDAO() {
    }

    @Pointcut("execution(* com.arakelyan.springdemo.service.*.*(..))")
    public void pointcutForBeforeAdviceForService() {
    }

    @Pointcut("execution(* com.arakelyan.springdemo.controller.*.*(..))")
    public void pointcutForBeforeAdviceForController() {
    }

    @Pointcut("pointcutForBeforeAdviceForDAO() || pointcutForBeforeAdviceForService() || pointcutForBeforeAdviceForController()")
    public void forAppFlow() {
    }

    //add @Before advice

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("===>>> in @Before: Calling method>>> " + method);

        //display the arguments to the method

        //get the arguments
        Object[] args = joinPoint.getArgs();

        //loop thru and display the arguments
        for(Object tempArgs : args) {
            myLogger.info("====> argument: " + tempArgs);
        }

    }

    //Add @AfterReturning advice

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {

        //display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("===>>>in @AfterReturning: from method - " + method);

        //display data returned
        myLogger.info("===>>> Result = " + result);

    }

}
