package com.example.subscriptionsAPI.service;

import com.example.subscriptionsAPI.model.contract.ChangeSubscriptionStateResult;
import com.example.subscriptionsAPI.model.contract.DeletionResult;
import com.example.subscriptionsAPI.model.contract.RegistrationEntity;
import com.example.subscriptionsAPI.model.contract.RegistrationResult;
import com.example.subscriptionsAPI.model.entity.Subscription;
import com.example.subscriptionsAPI.repositories.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public RegistrationResult registerSubscription(RegistrationEntity registrationEntity) {
        Subscription subscription = new Subscription(
                registrationEntity.getServiceName(),
                registrationEntity.getSubscriptionStart(),
                registrationEntity.getSubscriptionExpiry(),
                registrationEntity.getNotificationDate(),
                registrationEntity.getSubscriptionState()
        );
        var registeredEntityID = customerRepository.addSubscription(registrationEntity.getCustomerID(),subscription);
        return new RegistrationResult(registeredEntityID,"Success");
    }

    public Map<Long, Subscription> getSubscriptions(Long customerID) {
        return customerRepository.getCustomersSubscriptions(customerID);
    }

    public Subscription getSubscription(Long customerID, Long subscriptionID) {
        return customerRepository.getSingleSubscription(customerID, subscriptionID);
    }

    public DeletionResult deleteSubscription(Long customerID, Long subscriptionID) {
        customerRepository.deleteSubscription(customerID, subscriptionID);
        return new DeletionResult("Record deleted successfully");
    }

    public ChangeSubscriptionStateResult updateSubscriptionState(Long customerID, Long subscriptionID, String newState) {
        if (newState.isBlank()) {
            throw new IllegalStateException("State parameter must not be null or blank");
        }
        customerRepository.changeSubscriptionState(customerID, subscriptionID, newState);
        return new ChangeSubscriptionStateResult("Subscription state updated successfully");
    }
}
