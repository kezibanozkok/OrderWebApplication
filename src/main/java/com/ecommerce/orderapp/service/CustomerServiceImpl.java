package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Customer;
import com.ecommerce.orderapp.domain.Role;
import com.ecommerce.orderapp.domain.User;
import com.ecommerce.orderapp.payload.CustomerPayload;
import com.ecommerce.orderapp.payload.UserPayload;
import com.ecommerce.orderapp.repository.CustomerRepository;
import com.ecommerce.orderapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, RoleService roleService, UserRepository userRepository, UserService userService) {
        this.customerRepository = customerRepository;
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.userService = userService;
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
    public void add(CustomerPayload customerPayload, UserPayload userPayload) {
        Optional<Role> optionalRole = roleService.findOne(userPayload.getRole());
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            User user = new User(null, userPayload.getUsername(), userPayload.getPassword(), role, userPayload.getIsActive());
            userRepository.save(user);
            Customer customer = new Customer(null, customerPayload.getFirstName(), customerPayload.getLastName(), customerPayload.getAddress(), user);
            customerRepository.save(customer);
        }
    }

    @Override
    public void update(CustomerPayload customerPayload, Long id) {
        Customer customer = customerRepository.getOne(id);

        customer.setFirstName(customerPayload.getFirstName());
        customer.setLastName(customerPayload.getLastName());
        customer.setAddress(customerPayload.getAddress());
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
