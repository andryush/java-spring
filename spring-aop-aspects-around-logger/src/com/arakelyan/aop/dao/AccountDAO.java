package com.arakelyan.aop.dao;

import com.arakelyan.aop.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private int age;

    public AccountDAO() {

    }

    public AccountDAO(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("___This is Runtime exception___");
        }

        List<Account> myAccount = new ArrayList<>();

        Account tempAccount1 = new Account("John", "First");
        Account tempAccount2 = new Account("Jane", "Second");
        Account tempAccount3 = new Account("Baby", "Third");

        myAccount.add(tempAccount1);
        myAccount.add(tempAccount2);
        myAccount.add(tempAccount3);

        return myAccount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addAccount() {
        System.out.println(getClass() + " => From addAccount method in AccountDAO <= ");
    }

    public void addAccount2(AccountDAO accountDAO, boolean vipFlag) {
        System.out.println(getClass() + " => From addAccount2 method in AccountDAO <= ");
    }


}
