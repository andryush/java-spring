package com.arakelyan.springboot.controller;

import com.arakelyan.springboot.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList;

    @PostConstruct
    private void loadData() {
        Employee em1 = new Employee(1, "Andrey", "Arakelyan", "andrey@arakelyan.com");
        Employee em2 = new Employee(2, "Andrey2", "Arakelyan2", "andrey2@arakelyan.com");
        Employee em3 = new Employee(3, "Andrey3", "Arakelyan3", "andrey3@arakelyan.com");

        employeeList = new ArrayList<>();

        employeeList.add(em1);
        employeeList.add(em2);
        employeeList.add(em3);

    }

    @GetMapping("/list")
    public String listEmployee(Model theModel) {

        theModel.addAttribute("employees", employeeList);

        return "list-employees";
    }



}
