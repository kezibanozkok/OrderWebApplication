package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.payload.ProductPayload;
import com.ecommerce.orderapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProductPage(Model model) {
        //Product product = new Product((long) 1, "iphoneX", 9000.0, 5);
        //productService.save(product);

        model.addAttribute("products", productService.getProducts());
        return "products";
    }

    @GetMapping("/add")
    public String addProductPage() {
        return "addProduct";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute ProductPayload productPayload) {
        productService.addProduct(productPayload);
        return "redirect:/products";
    }
    /*
    @DeleteMapping(value = "{/id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteItemById(id);
        return "redirect:/products";
    }
    */


}
