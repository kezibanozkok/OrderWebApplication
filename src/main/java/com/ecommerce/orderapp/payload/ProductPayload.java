package com.ecommerce.orderapp.payload;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductPayload {
    private String name;
    private BigDecimal price;
    private int stock;
    private Long product;
}
