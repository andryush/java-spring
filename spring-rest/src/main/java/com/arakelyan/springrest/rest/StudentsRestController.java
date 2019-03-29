package com.arakelyan.springrest.rest;

import com.arakelyan.springrest.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsRestController {

    private List<Student> theStudentsList;

    @PostConstruct
    public void loadData() {
        theStudentsList = new ArrayList<Student>();

        theStudentsList.add(new Student(1,"John", "Doe"));
        theStudentsList.add(new Student(2, "Jane", "Doe"));
        theStudentsList.add(new Student(3, "Baby", "Doe"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudentsList;
    }

    @GetMapping("/students/{studentsId}")
    public Student getStudentById(@PathVariable int studentsId) {

        if ((studentsId >= theStudentsList.size()) || (studentsId < 0)) {

            throw new StudentNotFoundException("Student ID not found: " + studentsId);
        }

        return theStudentsList.get(studentsId);

    }



}
