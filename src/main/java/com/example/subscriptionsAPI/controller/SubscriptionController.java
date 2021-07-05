package com.example.subscriptionsAPI.controller;

import com.example.subscriptionsAPI.model.contract.ChangeSubscriptionStateResult;
import com.example.subscriptionsAPI.model.contract.DeletionResult;
import com.example.subscriptionsAPI.model.contract.RegistrationEntity;
import com.example.subscriptionsAPI.model.contract.RegistrationResult;
import com.example.subscriptionsAPI.model.entity.Subscription;
import com.example.subscriptionsAPI.service.CustomerService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "api")
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

    @RequestMapping(value = "subscriptions/{id}", method = RequestMethod.DELETE)
    public DeletionResult removeSubscription(@ApiParam(value = "The ID of the customer whose subscription will be deleted") Long customerID,
                                             @PathVariable() Long id) {
        return customerService.deleteSubscription(customerID, id);
    }

    @RequestMapping(value = "subscriptions/{id}/update_state", method = RequestMethod.PATCH)
    public ChangeSubscriptionStateResult changeSubscriptionState(@ApiParam(value = "The ID of the relevant customer") Long customerID,
                                                                 @PathVariable() Long id, @RequestBody String newState) {
        return customerService.updateSubscriptionState(customerID, id, newState);
    }

}
