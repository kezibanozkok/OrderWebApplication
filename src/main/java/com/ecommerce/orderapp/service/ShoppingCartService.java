package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.exception.NotEnoughProductsInStockException;
import org.springframework.security.core.Authentication;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    Long checkout(Authentication authentication) throws NotEnoughProductsInStockException;

    BigDecimal getTotal();
}
