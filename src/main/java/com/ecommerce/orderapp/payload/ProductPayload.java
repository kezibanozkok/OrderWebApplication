package com.ecommerce.orderapp.payload;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductPayload {
    private String name;
    private double price;
    private int stock;
    private Long product;
}
