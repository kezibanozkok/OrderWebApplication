package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Customer;
import com.ecommerce.orderapp.payload.CustomerPayload;
import com.ecommerce.orderapp.payload.ProductPayload;
import com.ecommerce.orderapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getOne(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer addCustomer(CustomerPayload customerPayload) {
        Customer customer = new Customer(null, customerPayload.getFirstName(), customerPayload.getLastName(), customerPayload.getAddress(), customerPayload.getProducts());
        return customerRepository.save(customer);
    }

}
