package com.arakelyan.springdemo.service;

import com.arakelyan.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomerById(int id);

    void deleteCustomer(int id);

}
