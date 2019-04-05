package com.arakelyan.springboot.service;

import com.arakelyan.springboot.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void delete(int id);

}
