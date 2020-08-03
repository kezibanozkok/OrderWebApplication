package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Customer;
import com.ecommerce.orderapp.payload.CustomerPayload;
import com.ecommerce.orderapp.payload.UserPayload;

import java.util.List;

public interface CustomerService {
    Customer getOne(Long id);

    List<Customer> getCustomers();

    Customer save(Customer customer);

    void add(CustomerPayload customerPayload, UserPayload userPayload);

    void register(CustomerPayload customerPayload, UserPayload userPayload);

    void update(CustomerPayload customerPayload, Long id);

    void deleteById(Long id);
}