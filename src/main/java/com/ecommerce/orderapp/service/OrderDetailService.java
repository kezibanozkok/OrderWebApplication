package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    OrderDetail getOne(Long id);

    void save(OrderDetail orderDetail);

    List<OrderDetail> saveAll(List<OrderDetail> orderDetails);
}
