package com.ecommerce.orderapp.repository;

import com.ecommerce.orderapp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
