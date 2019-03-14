package com.arakelyan.aop.aspect;

import com.arakelyan.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component

public class Log4FindMethods {

    @AfterReturning(
            pointcut = "com.arakelyan.aop.aspect.AopExpressions.pointcutForFindMethods()",
            returning = "result"
    )
    public void log4FindMethod(JoinPoint joinPoint, List<Account> result) {

        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterReturning method: " + method);


        //print out the result of the method call
        System.out.println("\n====>>>> the result is: " + result);


        //post-process the data... let's modify it

        //convert the account name to upper case
        convertAccountNamesToUpperCase(result);
        System.out.println("\n====>>>> the result is: " + result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account tempAccount : result) {
            String accountUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(accountUpperName);
        }

    }

}
