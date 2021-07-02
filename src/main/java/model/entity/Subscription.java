package model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Subscription {

    private String serviceName;
    private Long subscriptionID;
    private LocalDate subscriptionStart;
    private LocalDate subscriptionExpiry;
    private LocalDate notificationDate;
    private String subscriptionState;
}
