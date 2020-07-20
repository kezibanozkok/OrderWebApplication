package com.ecommerce.orderapp.payload;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerPayload {

    private String firstName;
    private String lastName;
    private String address;
    private String username;
    private String password;
    private long id;
}
