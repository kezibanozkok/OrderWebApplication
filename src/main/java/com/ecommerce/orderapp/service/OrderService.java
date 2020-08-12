package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Order;
import com.ecommerce.orderapp.domain.OrderDetail;
import com.ecommerce.orderapp.payload.OrderPayload;
import com.ecommerce.orderapp.payload.ProductPayload;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface OrderService {

    Order getOne(Long id);

    List<Order> getOrders();

    void createOrder(Authentication authentication, OrderPayload orderPayload, ProductPayload productPayload);

    //void updateOrder(OrderPayload orderPayload, Long id);

    void deleteItemById(Long id);

    List<OrderDetail> getDetail(Long orderId);

    List<Order> saveAll(List<Order> orders);
}
