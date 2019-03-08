package com.arakelyan.springcrm.service;

import com.arakelyan.springcrm.DAO.CustomersDAO;
import com.arakelyan.springcrm.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomersService {

    @Autowired
    private CustomersDAO customersDAO;

    @Override
    @Transactional
    public List<Customers> getCustomers() {
        return customersDAO.getCustomers();
    }

    @Override
    @Transactional
    public Customers getCustomersById(int id) {
        return customersDAO.getCustomersById(id);
    }

    @Override
    @Transactional
    public void saveCustomers(Customers theCustomer) {
        customersDAO.saveCustomers(theCustomer);
    }
}
