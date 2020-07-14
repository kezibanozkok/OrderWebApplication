package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.payload.CustomerPayload;
import com.ecommerce.orderapp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "customers";
    }

    @GetMapping("/add")
    public String addCustomer() {
        return "addCustomer";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute CustomerPayload customerPayload) {
        customerService.addCustomer(customerPayload);
        return "redirect:/customers";
    }

}
