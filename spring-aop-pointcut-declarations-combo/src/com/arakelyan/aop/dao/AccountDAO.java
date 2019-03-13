package com.arakelyan.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println("In get name");
        return name;
    }

    public void setName(String name) {
        System.out.println("In set name");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("In get serviceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("In set serviceCode");
        this.serviceCode = serviceCode;
    }

    public void addAccount() {
        System.out.println(getClass() + " ::: Adding an account ::: ");
    }
}
