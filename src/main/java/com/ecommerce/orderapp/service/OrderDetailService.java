package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.OrderDetail;

public interface OrderDetailService {

    OrderDetail getOne(Long id);

    void save(OrderDetail orderDetail);
}
