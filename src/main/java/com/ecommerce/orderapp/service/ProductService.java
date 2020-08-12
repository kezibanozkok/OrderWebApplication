package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.payload.ProductPayload;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product getOne(Long id);

    List<Product> getProducts();

    Product save(Product product);

    List<Product> saveAll(List<Product> products);

    void addProduct(ProductPayload productPayload);

    void update(ProductPayload productPayload, Long id);

    void deleteItemById(Long id);

    Optional<Product> findById(Long id);
}
