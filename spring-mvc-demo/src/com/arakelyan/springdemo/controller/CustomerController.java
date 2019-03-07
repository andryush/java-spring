package com.arakelyan.springdemo.controller;

import com.arakelyan.springdemo.classes.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        StringTrimmerEditor stringTrimmerEditor =
                new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showCustomerForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "customerShowForm";

    }

    @RequestMapping("/processCustomerForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult bindingResult) {
        System.out.println("Last name: |" + theCustomer.getLastName() + "|");

        System.out.println("Binding results: " + bindingResult);

        if (bindingResult.hasErrors()) {
            return "customerShowForm";
        }
        else {
            return "customerConfirmation";
        }

    }


}


