package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Order;
import com.ecommerce.orderapp.payload.CustomerPayload;
import com.ecommerce.orderapp.payload.OrderPayload;
import com.ecommerce.orderapp.payload.ProductPayload;

import java.util.List;

public interface OrderService {

    Order getOne(Long id);

    List<Order> getOrders();

    void createOrder(OrderPayload orderPayload, CustomerPayload customerPayload, ProductPayload productPayload);

    //void updateOrder(OrderPayload orderPayload, Long id);

    void deleteItemById(Long id);

    //List<OrderDetail> getDetail(Long orderId);
}
