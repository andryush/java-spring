package com.arakelyan.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "hello-world-form-new";
    }

    @RequestMapping("/processFormVersion2")
    public String processForm() {
        return "helloworld";
    }


    @RequestMapping("/processForm")
    public String allCaps(HttpServletRequest request, Model model) {

        //1 Read request param from the HTML form
        String theName = request.getParameter("studentName");

        //2 Uppercase request param from html
        theName = theName.toUpperCase();

        //3 Result message with uppercase request param from HTML
        String result = "hi there " + theName;

        //4 Write to model: attribute name WHATEVER, value  result variable from 3
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processForm2")
    public String allCaps2(
            @RequestParam("studentName") String theName,
            @RequestParam("studentLastName") String theLastName,
            Model model) {

        theName = theName.toUpperCase();
        theLastName = theLastName.toUpperCase();

        String result = "Welcome " + theName + " " + theLastName;

        model.addAttribute("result", result);

        return "helloworld";

    }



}
