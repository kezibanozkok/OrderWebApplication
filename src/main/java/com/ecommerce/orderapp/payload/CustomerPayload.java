package com.ecommerce.orderapp.payload;

import com.ecommerce.orderapp.domain.Product;
import com.ecommerce.orderapp.domain.User;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.Set;

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

    private User user;
}
