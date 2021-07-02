package model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class Customer {

    private Long customerID;
    private String email;
    private String name;
    private String lastName;
    private Set<Subscription> subscriptions;
}
