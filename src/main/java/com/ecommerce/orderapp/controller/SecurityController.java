package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.payload.CustomerPayload;
import com.ecommerce.orderapp.payload.UserPayload;
import com.ecommerce.orderapp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private final CustomerService customerService;

    public SecurityController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login?error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute CustomerPayload customerPayload, @ModelAttribute UserPayload userPayload) {
        customerService.register(customerPayload, userPayload);
        return "redirect:/login";
    }
}
