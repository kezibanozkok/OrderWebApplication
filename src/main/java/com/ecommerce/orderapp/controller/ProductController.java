package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.payload.ProductPayload;
import com.ecommerce.orderapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {"products"})
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProductPage(Model model) {
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

    @GetMapping("/update/{id}")
    public String updateProductPage(@PathVariable Long id) {
        return "updateProduct";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@ModelAttribute ProductPayload productPayload, @PathVariable Long id) {
        productService.update(productPayload, id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteItemById(id);
        return "redirect:/products";
    }

    @GetMapping("/403")
    public String error() {
        return "403";
    }
}
