package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.payload.RolePayload;
import com.ecommerce.orderapp.payload.UserPayload;

public interface UserService {

    void addUser(UserPayload userPayload);
}
