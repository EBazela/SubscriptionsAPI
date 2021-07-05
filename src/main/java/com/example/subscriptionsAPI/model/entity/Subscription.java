package com.example.subscriptionsAPI.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    private String serviceName;
    private LocalDate subscriptionStart;
    private LocalDate subscriptionExpiry;
    private LocalDate notificationDate;
    private String subscriptionState;
}
