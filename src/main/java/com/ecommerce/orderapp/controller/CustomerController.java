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
    public String addCustomerPage() {
        return "addCustomer";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute CustomerPayload customerPayload) {
        customerService.add(customerPayload);
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

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}
