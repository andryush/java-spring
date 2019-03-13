package com.arakelyan.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void firstMembership() {
        System.out.println(getClass() + " ::: Adding a membership ::: ");
    }

}
