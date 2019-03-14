package com.arakelyan.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.arakelyan.aop.dao.*.add*(..))")
    public void pointcutForDAOPackage() {
    }


    @Pointcut("execution(* com.arakelyan.aop.dao.*.find*(..))")
    public void pointcutForFindMethods(){

    }

}
