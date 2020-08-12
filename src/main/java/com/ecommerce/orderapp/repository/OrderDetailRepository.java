package com.ecommerce.orderapp.repository;

import com.ecommerce.orderapp.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    //@Query("SELECT a FROM OrderDetail a where a.id=128")
    List<OrderDetail> findOrderDetailByOrder_Id(Long orderId);

}
