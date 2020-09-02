package com.ecommerce.orderapp.repository;

import com.ecommerce.orderapp.domain.OrderDetail;
import com.ecommerce.orderapp.report.OrderDetailReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    //@Query("SELECT a FROM OrderDetail a where a.id=128")
    List<OrderDetail> findOrderDetailByOrder_Id(Long orderId);
/*
    select o.id siparisNo, o.order_date siparisTarihi, p.name urunAdi, d.quantity miktar
    from orders o inner join customer c inner join order_detail d inner join product p
    on o.id = d.order_id and c.id = o.customer_id and p.id = d.product_id
    and o.order_date between '2020-08-01' and '2020-08-12';
    */

    @Query("SELECT new com.ecommerce.orderapp.report.OrderDetailReport(o.id, o.orderDate, p.name, d.quantity) FROM " +
            "Order o inner join OrderDetail d on o.id = d.order.id and o.orderDate between :start and :end " +
            "inner join Product p on p.id = d.product.id"
    )
    List<OrderDetailReport> findOrdersByDateBetween(@Param("start") Date start, @Param("end") Date end);
}
