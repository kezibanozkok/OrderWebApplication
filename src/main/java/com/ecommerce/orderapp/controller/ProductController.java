package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProductPage(Model model) {
        //Product product = new Product((long) 1, "iphoneX", 9000.0, 5);
        //productService.save(product);

        model.addAttribute("products", productService.getProducts());
        return "products";
    }

}
