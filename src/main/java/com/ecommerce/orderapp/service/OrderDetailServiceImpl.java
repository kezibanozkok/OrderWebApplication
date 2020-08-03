package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.OrderDetail;
import com.ecommerce.orderapp.repository.OrderDetailRepository;

public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }


    @Override
    public OrderDetail getOne(Long id) {
        return orderDetailRepository.getOne(id);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }
}
