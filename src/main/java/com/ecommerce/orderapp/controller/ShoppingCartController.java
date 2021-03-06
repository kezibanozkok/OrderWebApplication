package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.exception.NotEnoughProductsInStockException;
import com.ecommerce.orderapp.service.OrderService;
import com.ecommerce.orderapp.service.ProductService;
import com.ecommerce.orderapp.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final OrderService orderService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        modelAndView.addObject("products", shoppingCartService.getProductsInCart());
        modelAndView.addObject("total", shoppingCartService.getTotal().toString());
        return modelAndView;
    }

    public ModelAndView message() {
        ModelAndView modelAndView = new ModelAndView("/message");
        modelAndView.addObject("orderId", shoppingCartService.getProductsInCart());
        return modelAndView;
    }

    @GetMapping("/addProduct/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::addProduct);
        return shoppingCart();
    }

    @GetMapping("/removeProduct/{productId}")
    public ModelAndView removeProductFromCart(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::removeProduct);
        return shoppingCart();
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(Authentication authentication) {
        Long orderId;
        try {
            orderId = shoppingCartService.checkout(authentication);
        } catch (NotEnoughProductsInStockException e) {
            return shoppingCart().addObject("outOfStockMessage", e.getMessage());
        }
        ModelAndView modelAndView = new ModelAndView("/message");
        modelAndView.addObject("orderId", orderId);
        return modelAndView;
    }
}
