package com.arakelyan.aop;

import com.arakelyan.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        theAccountDAO.addAccount();

    }
}
