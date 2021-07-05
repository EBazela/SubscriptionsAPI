package com.example.subscriptionsAPI.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Customer {

    private Long customerID;
    private String email;
    private String name;
    private String lastName;
    private Map<Long, Subscription> subscriptions;
}
