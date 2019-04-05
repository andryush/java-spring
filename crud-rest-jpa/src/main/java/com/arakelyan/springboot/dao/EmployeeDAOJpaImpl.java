package com.arakelyan.springboot.dao;

import com.arakelyan.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class, id);


        return employee;
    }

    @Override
    public void save(Employee employee) {

        Employee employee1 = entityManager.merge(employee);

        employee.setId(employee1.getId());

    }

    @Override
    public void delete(int id) {

        Query query =
                entityManager.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();

    }
}
