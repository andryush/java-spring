package com.arakelyan.springrest.rest;

import com.arakelyan.springrest.entity.Customer;
import com.arakelyan.springrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomersRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customersId}")
    public Customer getCustomerById(@PathVariable int customersId) {

        Customer theCustomer = customerService.getCustomer(customersId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer ID not found - " + customersId);
        }

        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer theCustomer = customerService.getCustomer(customerId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer ID not found - " + customerId);
        }

        customerService.deleteCustomer(customerId);
        return "Deleted customer ID - " + customerId;
    }
}
