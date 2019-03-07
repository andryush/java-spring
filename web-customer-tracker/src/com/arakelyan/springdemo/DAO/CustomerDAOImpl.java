package com.arakelyan.springdemo.DAO;

import com.arakelyan.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create query
        Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);

        //create list to execute query to the list
        List<Customer> customers = theQuery.getResultList();

        return customers;

    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theCustomer);


    }

    @Override
    public Customer getCustomerById(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customer tempCustomer = session.get(Customer.class, id);

        return tempCustomer;


    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        Customer tempCustomer = session.get(Customer.class, id);

        session.delete(tempCustomer);
    }

}
