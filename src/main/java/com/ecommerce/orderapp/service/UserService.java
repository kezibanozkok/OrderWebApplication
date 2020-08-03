package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.User;
import com.ecommerce.orderapp.payload.UserPayload;

import java.util.Optional;

public interface UserService {

    void addUser(UserPayload userPayload);

    Optional<User> findOne(Long id);

    Optional<User> findByUsername(String username);
}
