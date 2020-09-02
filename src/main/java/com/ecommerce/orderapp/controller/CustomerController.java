package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.domain.Role;
import com.ecommerce.orderapp.payload.CustomerPayload;
import com.ecommerce.orderapp.payload.UserPayload;
import com.ecommerce.orderapp.service.CustomerService;
import com.ecommerce.orderapp.service.RoleService;
import com.ecommerce.orderapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final UserService userService;
    private final RoleService roleService;

    public CustomerController(CustomerService customerService, UserService userService, RoleService roleService) {
        this.customerService = customerService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "customers";
    }

    @GetMapping("/add")
    public String addCustomerPage(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "addCustomer";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute CustomerPayload customerPayload, @ModelAttribute UserPayload userPayload) {
        customerService.add(customerPayload, userPayload);
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public String updateCustomerPage(@PathVariable Long id) {
        return "updateCustomer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@ModelAttribute CustomerPayload customerPayload, @PathVariable Long id) {
        customerService.update(customerPayload, id);
        return "redirect:/customers";
    }
}
