package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.payload.ProductPayload;
import com.ecommerce.orderapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product getOne(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product addProduct(ProductPayload productPayload) {
        Product product = new Product(null, productPayload.getName(), productPayload.getPrice(), productPayload.getStock());
        return productRepository.save(product);
    }
    /*
    @Override
    public void deleteItemById(Long id) {
        productRepository.deleteById(id);
    }*/

}
