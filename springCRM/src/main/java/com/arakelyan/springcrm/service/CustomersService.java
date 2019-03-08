package com.arakelyan.springcrm.service;

import com.arakelyan.springcrm.entity.Customers;

import java.util.List;

public interface CustomersService {
    List<Customers> getCustomers();
    Customers getCustomersById(int id);
    void saveCustomers(Customers theCustomer);
}
