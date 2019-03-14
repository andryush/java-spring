package com.arakelyan.aop;

import com.arakelyan.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        boolean tripWire = true;
        List<Account> theAccount = null;

        try {
            theAccount = theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception exc) {
            System.out.println("\n\n Main program caught an exception>> " + exc);
        }

        System.out.println("\n\n Main program: AfterThrowingMain");
        System.out.println("-------");

        System.out.println(theAccount);
        System.out.println("-------");

        System.out.println("\n");

        context.close();

    }
}
