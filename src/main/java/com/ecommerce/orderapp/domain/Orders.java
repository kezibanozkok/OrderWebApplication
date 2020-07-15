package com.ecommerce.orderapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders {

    @Id
    @GeneratedValue
    private Long id;
    private Long customerId;
    private Date orderDate;
    private String status;
    private String description;
}
