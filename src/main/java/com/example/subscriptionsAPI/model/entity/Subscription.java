package com.example.subscriptionsAPI.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    private String serviceName;
    private LocalDate subscriptionStart;
    private LocalDate subscriptionExpiry;
    private LocalDate notificationDate;
    private String subscriptionState;
}
