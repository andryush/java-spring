package com.arakelyan.springcrm.controller;

import com.arakelyan.springcrm.entity.Customers;
import com.arakelyan.springcrm.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @RequestMapping("/test")
    public String test() {
        return "jft";
    }

    @GetMapping("/list")
    public String customersList(Model theModel) {

        List<Customers> customers = customersService.getCustomers();

        theModel.addAttribute("customers", customers);

        return "customers-list";
    }

    @GetMapping("/updateCustomers")
    public String updateCustomers(@RequestParam("customersId") int theId, Model theModel ) {

        Customers customers = customersService.getCustomersById(theId);

        theModel.addAttribute("customers", customers);

        return "update-form";
    }
}
