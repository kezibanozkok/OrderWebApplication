package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.payload.OrderPayload;
import com.ecommerce.orderapp.payload.ProductPayload;
import com.ecommerce.orderapp.service.CustomerService;
import com.ecommerce.orderapp.service.OrderService;
import com.ecommerce.orderapp.service.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductService productService;

    public OrderController(OrderService orderService, CustomerService customerService, ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @GetMapping
    public String getOrderPage(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {

        model.addAttribute("customers", customerService.getCustomers());
        model.addAttribute("products", productService.getProducts());
        return "createOrder";
    }

    @PostMapping("/create")
    public String createOrder(Authentication authentication, @ModelAttribute OrderPayload orderPayload, @ModelAttribute ProductPayload productPayload) {
        orderService.createOrder(authentication, orderPayload, productPayload);
        return "redirect:/orders";
    }

    @GetMapping("/update/{id}")
    public String updateOrderPage(@PathVariable Long id) {
        return "updateOrder";
    }
    /*
    @PostMapping("/update/{id}")
    public String updateOrder(@ModelAttribute OrderPayload orderPayload, @PathVariable Long id) {
        orderService.updateOrder(orderPayload, id);
        return "redirect:/orders";
    }*/

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteItemById(id);
        return "redirect:/orders";
    }

    @GetMapping("/detail/{orderId}")
    public String getDetailPage(Model model, @PathVariable Long orderId) {
        model.addAttribute("orderDetailList", orderService.getDetail(orderId));
        return "orderDetail";
    }
}