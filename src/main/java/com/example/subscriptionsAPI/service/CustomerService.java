package com.example.subscriptionsAPI.service;

import com.example.subscriptionsAPI.model.contract.RegistrationEntity;
import com.example.subscriptionsAPI.model.contract.RegistrationResult;
import com.example.subscriptionsAPI.model.entity.Subscription;
import com.example.subscriptionsAPI.repositories.CustomerRepository;
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
        var registrationResponse = customerRepository.addSubscription(registrationEntity.getCustomerID(),subscription);
        return new RegistrationResult(registrationResponse.productID(),"Success");
    }

    public Map<Long, Subscription> getSubscriptions(Long customerID) {
        return customerRepository.getCustomersSubscriptions(customerID);
    }

    public Subscription getSubscription(Long customerID, Long subscriptonID) {
        return customerRepository.getSingleSubscription(customerID, subscriptonID);
    }
}
