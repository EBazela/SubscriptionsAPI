package com.example.subscriptionsAPI.model.contract;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class RegistrationEntity {

    @ApiParam(required = true, value = "Should be a valid service name.")
    private final String serviceName;
    @ApiParam(required = true, value = "Should be a valid customerID.")
    private final Long customerID;
    @ApiParam(value="Should be a LocalDate object with a date when subscription started")
    private final LocalDate subscriptionStart;
    @ApiParam(value="Should be a LocalDate object with a date when subscription should end")
    private final LocalDate subscriptionExpiry;
    @ApiParam(value="Should be a LocalDate object with a date when email reminder should be sent")
    private final LocalDate notificationDate;
    @ApiParam(value="Should be String value of subscription's current state")
    private final String subscriptionState;
}
