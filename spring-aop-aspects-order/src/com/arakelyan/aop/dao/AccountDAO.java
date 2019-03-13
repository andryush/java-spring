package com.arakelyan.aop.dao;

import org.springframework.stereotype.Component;

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


}
