package com.arakelyan.aop.dao;

import com.arakelyan.aop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK : ADDING AN ACCOUNT");
    }

    public void addAccount2(Account account) {
        System.out.println(getClass() + ": ADDING ACCOUNT with ARGUMENT type ACCOUNT :");
    }

    public void addAccount3(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : ADDING ACCOUNT with ARGUMENT type ACCOUNT and one other any type ARGUMENT : ");
    }

    public boolean doWork() {
        System.out.println(getClass() + " DOING SOME WORK ");
        return false;
    }

}
