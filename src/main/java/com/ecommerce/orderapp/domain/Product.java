package com.ecommerce.orderapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private double price;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
