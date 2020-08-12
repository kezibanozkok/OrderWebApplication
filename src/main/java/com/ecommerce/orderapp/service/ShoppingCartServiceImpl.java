package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Order;
import com.ecommerce.orderapp.domain.OrderDetail;
import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.domain.User;
import com.ecommerce.orderapp.exception.NotEnoughProductsInStockException;
import com.ecommerce.orderapp.repository.OrderDetailRepository;
import com.ecommerce.orderapp.repository.OrderRepository;
import com.ecommerce.orderapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ProductRepository productRepository;
    private final UserService userService;
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    private final Map<Product, Integer> products = new HashMap<>();


    @Autowired
    public ShoppingCartServiceImpl(ProductRepository productRepository, UserService userService, ProductService productService, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.productService = productService;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    /**
     * If product is in the map just increment quantity by 1.
     * If product is not in the map with, add it with quantity 1
     *
     * @param product
     */
    @Override
    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    /**
     * If product is in the map with quantity > 1, just decrement quantity by 1.
     * If product is in the map with quantity 1, remove it from map
     *
     * @param product
     */
    @Override
    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }

    /**
     * @return unmodifiable copy of the map
     */
    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }

    /**
     * Checkout will rollback if there is not enough of some product in stock
     *
     * @throws NotEnoughProductsInStockException
     */
    @Override
    public void checkout(Authentication authentication) throws NotEnoughProductsInStockException {
        Product product;
        Date date = new Date();
        String username = authentication.getName();
        Optional<User> optionalUser = userService.findByUsername(username);
        Order order = null;
        OrderDetail orderDetail = null;
        User user = optionalUser.get();
        List<OrderDetail> orderDetails = new ArrayList<>();

        order = new Order(null, date, "Created", "siparis olusturuldu", user.getCustomer());

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            // Refresh quantity for every product before checking
            product = productRepository.getOne(entry.getKey().getId());
            if (product.getStock() < entry.getValue())
                throw new NotEnoughProductsInStockException(product);
            entry.getKey().setStock(product.getStock() - entry.getValue());

            orderDetail = new OrderDetail(null, entry.getValue(), product.getPrice(), product, order);

            orderDetails.add(orderDetail);
        }


        if (optionalUser.isPresent()) {
            //Product product = productService.getOne((productPayload.getProduct()));

            orderRepository.save(order);
            orderDetailRepository.saveAll(orderDetails);
            productRepository.saveAll(products.keySet());
            productRepository.flush();
            products.clear();
        }
    }

    @Override
    public BigDecimal getTotal() {
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
