package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Customer;
import com.ecommerce.orderapp.payload.CustomerPayload;

import java.util.List;

public interface CustomerService {
    Customer getOne(Long id);

    List<Customer> getCustomers();

    Customer save(Customer customer);

    Customer addCustomer(CustomerPayload customerPayload);

}
