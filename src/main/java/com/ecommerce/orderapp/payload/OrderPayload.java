package com.ecommerce.orderapp.payload;

import lombok.*;

import javax.persistence.Id;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderPayload {

    private Long customerId;
    private Long productId;
    private Long orderId;
    private String status;
    private String description;
    private int quantity;
    private double unitPrice;
}
