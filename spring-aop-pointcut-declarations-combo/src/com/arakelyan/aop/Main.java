package com.arakelyan.aop;

import com.arakelyan.aop.dao.AccountDAO;
import com.arakelyan.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(Config.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        theAccountDAO.addAccount();

        //call AccountDAO getters/setters
        theAccountDAO.setName("Test user");
        theAccountDAO.setServiceCode("333");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        context.close();

    }
}
