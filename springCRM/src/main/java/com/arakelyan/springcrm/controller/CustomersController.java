package com.arakelyan.springcrm.controller;

import com.arakelyan.springcrm.entity.Customers;
import com.arakelyan.springcrm.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saveCustomers")
    public String saveCustomers(@ModelAttribute("customers") Customers theCustomer) {

        customersService.saveCustomers(theCustomer);
        return "redirect:/customers/list";

    }

    @GetMapping("showFormForAddingCustomers")
    public String showFormForAddingCustomers(Model theModel) {

        Customers customers = new Customers();

        theModel.addAttribute("customers", customers);

        return "update-form";
    }

    @GetMapping("deleteCustomers")
    public String deleteCustomers(@RequestParam("customersId") int theId) {

        customersService.deleteCustomersById(theId);
        return "redirect:/customers/list";
    }

}
