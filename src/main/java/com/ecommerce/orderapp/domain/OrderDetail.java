package com.ecommerce.orderapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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
    private int quantity;
    private double unitPrice;

    @OneToMany(mappedBy = "orderDetail")
    private List<Product> product;

}
