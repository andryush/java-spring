package com.arakelyan.springdemo.DAO;

import com.arakelyan.springdemo.entity.Customer2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Customer2DAOImpl implements Customer2DAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer2> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer2> tempQuery = session.createQuery("from Customer2", Customer2.class);

        List<Customer2> customers = tempQuery.getResultList();

        return customers;
    }
}
