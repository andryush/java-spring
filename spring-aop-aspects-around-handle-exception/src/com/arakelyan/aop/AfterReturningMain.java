//package com.arakelyan.aop;
//
//import com.arakelyan.aop.dao.AccountDAO;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.List;
//
//public class AfterReturningMain {
//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new
//                AnnotationConfigApplicationContext(Config.class);
//
//        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
//
//        List<Account> theAccount = theAccountDAO.findAccounts(tripWire);
//
//        System.out.println("\n\n Main program: AfterReturningMain");
//        System.out.println("------");
//
//        System.out.println(theAccount);
//        System.out.println("------");
//
//        System.out.println("\n");
//
//        context.close();
//
//    }
//}
