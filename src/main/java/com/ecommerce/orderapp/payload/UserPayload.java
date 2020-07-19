package com.ecommerce.orderapp.payload;

import com.ecommerce.orderapp.domain.Customer;
import com.ecommerce.orderapp.domain.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    private int isActive;
}
