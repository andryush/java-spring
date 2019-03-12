package com.arakelyan.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //this is where we add all of our related advices for logging

    //let's start with @Before advice
    //@Before("execution(public void addAccount())")

    //execution only in specific class addAccount method, class full path required
    //@Before("execution(public void com.arakelyan.aop.dao.AccountDAO.addAccount())")

    //execution with wildcard any method which name starts with add
    //@Before("execution(public void add*())")

    //execution ANY return type(void, String, Boolean etc) with any method which name starts with add
    //@Before("execution(* add*())")

    //execution ANY return type ANY method which name starts with add and which has Argument type Account
    //@Before("execution(* add*(com.arakelyan.aop.Account))")

    //execution ANY return type ANY method which name starts with add and which has Argument type Account and many other
    //@Before("execution(* add*(com.arakelyan.aop.Account, ..))")

    //execution ANY return type ANY METHOD from ANY CLASS in specific package with any type 0 or many arguments
    @Before("execution(* com.arakelyan.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Executing @Before advice on addAccount(with param type ACCOUNT an one other any type)");

    }

}
