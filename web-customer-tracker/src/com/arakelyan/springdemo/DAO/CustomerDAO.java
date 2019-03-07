package com.arakelyan.springdemo.DAO;

import com.arakelyan.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomerById(int id);

    void deleteCustomer(int id);
}
