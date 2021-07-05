package com.example.subscriptionsAPI.controller;

import com.example.subscriptionsAPI.model.contract.RegistrationEntity;
import com.example.subscriptionsAPI.model.contract.RegistrationResult;
import com.example.subscriptionsAPI.model.entity.Subscription;
import com.example.subscriptionsAPI.service.CustomerService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final CustomerService customerService;

    @RequestMapping(value = "register_subscription", method = RequestMethod.POST)
    public RegistrationResult registerSubscription(@RequestBody RegistrationEntity registrationEntity) {
        return customerService.registerSubscription(registrationEntity);
    }

    @RequestMapping(value = "subscriptions", method = RequestMethod.GET)
    public Map<Long, Subscription> getSubscriptions(@ApiParam(value = "The ID of the customer whose subscriptions should be retrieved") Long customerID) {
        return customerService.getSubscriptions(customerID);
    }

    @RequestMapping(value = "subscriptions/{id}", method = RequestMethod.GET)
    public Subscription getSubscription(@ApiParam(value = "The ID of the customer who owes the subscription")Long customerID,
                                       @PathVariable() Long id) {
        return customerService.getSubscription(customerID, id);
    }

}
