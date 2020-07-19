package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.domain.Role;
import com.ecommerce.orderapp.payload.RolePayload;
import com.ecommerce.orderapp.payload.UserPayload;
import com.ecommerce.orderapp.service.RoleService;
import com.ecommerce.orderapp.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;
    private final RoleService roleService;

    public UserController(UserDetailsServiceImpl userDetailsService, RoleService roleService) {
        this.userDetailsService = userDetailsService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    private String getPage() {
        return "user";
    }

    @GetMapping("/user/add")
    public String addPage() {
        return "addUser";
    }

    @PostMapping("/user/add")
    public String save(@ModelAttribute UserPayload userPayload) {
        userDetailsService.addUser(userPayload);
        return "redirect:/user";
    }
}
