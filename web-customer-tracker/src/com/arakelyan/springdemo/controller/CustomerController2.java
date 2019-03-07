package com.arakelyan.springdemo.controller;

import com.arakelyan.springdemo.DAO.Customer2DAO;
import com.arakelyan.springdemo.entity.Customer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController2 {

    @Autowired
    private Customer2DAO customer2DAO;

    @RequestMapping("/list2")
    public String listCustomers(Model theModel) {

        List<Customer2> customers = customer2DAO.getCustomers();

        theModel.addAttribute("customersAtr", customers);

        return "list-customers2";
    }

}
