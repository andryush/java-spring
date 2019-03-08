package com.arakelyan.springcrm.DAO;

import com.arakelyan.springcrm.entity.Customers;

import java.util.List;

public interface CustomersDAO {

    List<Customers> getCustomers();

    Customers getCustomersById(int id);

    void saveCustomers(Customers theCustomer);

}
