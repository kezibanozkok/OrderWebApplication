package com.ecommerce.orderapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "customer")
    private List<Order> order;

    public Customer(Long id, String firstName, String lastName, String address, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.user = user;
    }
}
