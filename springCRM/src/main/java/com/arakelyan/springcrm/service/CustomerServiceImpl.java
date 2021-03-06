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

    @Override
    @Transactional
    public void deleteCustomersById(int id) {
        customersDAO.deleteCustomersById(id);
    }

    @Override
    @Transactional
    public List<Customers> searchTheCustomer(String theCustomerName) {
        return customersDAO.searchTheCustomer(theCustomerName);
    }

}
