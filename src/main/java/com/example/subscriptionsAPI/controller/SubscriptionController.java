package com.example.subscriptionsAPI.controller;

import com.example.subscriptionsAPI.model.contract.RegistrationEntity;
import com.example.subscriptionsAPI.model.contract.RegistrationResult;
import com.example.subscriptionsAPI.model.entity.Subscription;
import com.example.subscriptionsAPI.service.CustomerService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final CustomerService customerService;

    @RequestMapping(value = "register_subscription", method = RequestMethod.POST)
    public RegistrationResult registerSubscription(@RequestBody RegistrationEntity registrationEntity) {
        return customerService.registerSubscription(registrationEntity);
    }


//    @RequestMapping(value = "subscriptions", method = RequestMethod.GET)
//    public Map<Long, Subscription> getSubscriptions(@ApiParam(value = "The ID of the customer whose subscriptions should be retrieved") Long customerID) {
//        return customerService.getSubscriptions(customerID);
//    }

}
