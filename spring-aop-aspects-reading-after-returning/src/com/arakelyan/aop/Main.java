package com.arakelyan.aop;

import com.arakelyan.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        AccountDAO accountDAO = new AccountDAO();
        theAccountDAO.addAccount();
        theAccountDAO.addAccount2(accountDAO, true);

    }
}
