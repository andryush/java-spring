package com.arakelyan.aop;

import com.arakelyan.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        //read the spring config java class
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);

        //get the bean from a spring container
        AccountDAO theAccount = context.getBean("accountDAO", AccountDAO.class);

        //call the business method
        theAccount.addAccount();

        //let'd do it again
        System.out.println("\nLet's do it again\n");

        //call the business method again
        theAccount.addAccount();

        //close the context
        context.close();
    }

}
