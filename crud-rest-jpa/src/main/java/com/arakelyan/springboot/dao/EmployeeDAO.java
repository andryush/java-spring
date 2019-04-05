package com.arakelyan.springboot.dao;

import com.arakelyan.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void delete(int id);

}
