package com.arakelyan.springcrm.DAO;

import com.arakelyan.springcrm.entity.Customers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomersDAOImpl implements CustomersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customers> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customers> query = session.createQuery("from Customers", Customers.class);

        List<Customers> customers = query.getResultList();

        return customers;
    }

    @Override
    public Customers getCustomersById(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customers customers = session.get(Customers.class, id);

        return customers;
    }

    @Override
    public void saveCustomers(Customers theCustomer) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theCustomer);
    }
}
