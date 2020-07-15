package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Orders;
import com.ecommerce.orderapp.payload.OrderPayload;
import com.ecommerce.orderapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Orders getOne(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void createOrder(OrderPayload orderPayload) {
        Date date = new Date();

        Orders order = new Orders(null, orderPayload.getCustomerId(), date, orderPayload.getStatus(), orderPayload.getDescription());
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(OrderPayload orderPayload, Long id) {
        Orders order = orderRepository.getOne(id);
        order.setStatus(orderPayload.getStatus());
        orderRepository.save(order);
    }

    @Override
    public void deleteItemById(Long id) {
        orderRepository.deleteById(id);
    }
}
