package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Customer;
import com.ecommerce.orderapp.domain.Order;
import com.ecommerce.orderapp.domain.OrderDetail;
import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.payload.CustomerPayload;
import com.ecommerce.orderapp.payload.OrderPayload;
import com.ecommerce.orderapp.payload.ProductPayload;
import com.ecommerce.orderapp.repository.OrderDetailRepository;
import com.ecommerce.orderapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, CustomerService customerService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.customerService = customerService;
        this.productService = productService;
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
    public void createOrder(OrderPayload orderPayload, CustomerPayload customerPayload, ProductPayload productPayload) {
        Date date = new Date();

        Customer customer = customerService.getOne(customerPayload.getId());
        Product product = productService.getOne((productPayload.getProduct()));
        List<Product> products = new ArrayList<>();
        products.add(product);

        Order order = new Order(null, date, null, null, customer);
        OrderDetail orderDetail = new OrderDetail(null, orderPayload.getQuantity(), orderPayload.getUnitPrice(), products);
        orderRepository.save(order);
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

    /*
    @Override
    public List<OrderDetail> getDetail(Long orderId) {
        return orderDetailRepository.findOrderDetailByOrderId(orderId);
    }
    */
}
