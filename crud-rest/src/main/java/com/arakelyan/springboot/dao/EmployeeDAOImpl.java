package com.arakelyan.springboot.dao;

import com.arakelyan.springboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<Employee> theQuery =
                session.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;

    }

    @Override
    public Employee findById(int id) {

        Session session = entityManager.unwrap(Session.class);

        Employee theEmployee = session.get(Employee.class, id);

        return theEmployee;
    }

    @Override
    public void save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);

    }

    @Override
    public void delete(int id) {

        Session session = entityManager.unwrap(Session.class);

        Employee theEmployee = session.get(Employee.class, id);

        session.delete(theEmployee);

    }
}
