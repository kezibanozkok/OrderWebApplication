package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.payload.ProductPayload;

import java.util.List;

public interface ProductService {
    Product getOne(Long id);

    List<Product> getProducts();

    Product save(Product product);

    Product addProduct(ProductPayload productPayload);

    //void deleteItemById(Long id);

}
