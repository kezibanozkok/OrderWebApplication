package com.ecommerce.orderapp.payload;

import com.ecommerce.orderapp.domain.User;
import lombok.*;

import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RolePayload {

    private String name;

    private List<User> users;

}
