package com.ecommerce.orderapp.payload;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderPayload {

    private Long customer;
    private String product;
    private String status;
    private int quantity;
    private double unitPrice;
}
