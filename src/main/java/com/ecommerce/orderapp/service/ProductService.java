package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Product;

import java.util.List;

public interface ProductService {
    Product getOne(Long id);

    List<Product> getProducts();

    Product save(Product product);

}
