package com.ecommerce.orderapp.report;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderDetailReport implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long orderId;
    private Date orderDate;
    private String productName;
    private int quantity;
}
