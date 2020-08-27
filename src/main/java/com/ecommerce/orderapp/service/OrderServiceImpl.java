package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Order;
import com.ecommerce.orderapp.domain.OrderDetail;
import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.domain.User;
import com.ecommerce.orderapp.payload.OrderPayload;
import com.ecommerce.orderapp.payload.ProductPayload;
import com.ecommerce.orderapp.repository.OrderDetailRepository;
import com.ecommerce.orderapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;
    private final UserService userService;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductService productService, UserService userService) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public Order getOne(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public void createOrder(Authentication authentication, OrderPayload orderPayload, ProductPayload productPayload) {
        Date date = new Date();
        int quantity = orderPayload.getQuantity();
        String username = authentication.getName();
        Optional<User> optionalUser = userService.findByUsername(username);

        if (optionalUser.isPresent()) {
            Product product = productService.getOne((productPayload.getProduct()));
            User user = optionalUser.get();
            Order order = new Order(null, date, "Created", null, user.getCustomer());
            orderRepository.save(order);
            OrderDetail orderDetail = new OrderDetail(null, quantity, product.getPrice(), product, order);
            orderDetailRepository.save(orderDetail);
        }
    }

    /*
    @Override
    public void updateOrder(OrderPayload orderPayload, Long id) {
        Order order = orderRepository.getOne(id);
        order.setStatus(orderPayload.getStatus());
        orderRepository.save(order);
    }*/

    @Override
    public void deleteItemById(Long id) {
        orderRepository.deleteById(id);
    }

    public List<OrderDetail> getDetail(Long orderId) {
        return orderDetailRepository.findOrderDetailByOrder_Id(orderId);
    }
}