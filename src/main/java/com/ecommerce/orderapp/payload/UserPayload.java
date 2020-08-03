package com.ecommerce.orderapp.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPayload {

    private String username;

    private String password;

    private Long role;

    //private int isActive;
}
