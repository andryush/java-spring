package com.arakelyan.aop;

import com.arakelyan.aop.dao.AccountDAO;
import com.arakelyan.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        //read the spring config java class
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);

        //get the bean from a spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //call the business method
        theAccountDAO.addAccount();
        theMembershipDAO.addAccount();

        Account account = new Account();
        //theAccountDAO.addAccount2(account);

        theAccountDAO.addAccount3(account, true);

        theAccountDAO.doWork();
        //let'd do it again
        //System.out.println("\nLet's do it again\n");

        //call the business method again
        //theAccountDAO.addAccount();
        //theMembershipDAO.addAccount();

        //close the context
        context.close();
    }

}
