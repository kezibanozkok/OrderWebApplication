package com.ecommerce.orderapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetail {

    @Id
    @GeneratedValue
    private Long id;
    private Long productId;
    private Long orderId;
    private int quantity;
    private double unitPrice;
}
