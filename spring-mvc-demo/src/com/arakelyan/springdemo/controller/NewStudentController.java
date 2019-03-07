package com.arakelyan.springdemo.controller;

import com.arakelyan.springdemo.classes.NewStudent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newstudent")
public class NewStudentController {

    @RequestMapping("/showNewStudentForm")
    public String showForm(Model newModel) {

        NewStudent newStudent = new NewStudent();

        newModel.addAttribute("newstudent", newStudent);

        return "newStudentForm";
    }

    @RequestMapping("/processNewForm")
    public String processNewForm(@ModelAttribute("newstudent") NewStudent newStudent) {

        return "newStudentConfirmation";
    }



}


