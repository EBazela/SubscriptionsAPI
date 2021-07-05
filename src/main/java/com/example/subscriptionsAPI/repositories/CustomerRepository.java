package com.example.subscriptionsAPI.repositories;

import com.example.subscriptionsAPI.model.contract.RegistrationResult;
import com.example.subscriptionsAPI.model.entity.Customer;
import com.example.subscriptionsAPI.model.entity.Subscription;
import com.example.subscriptionsAPI.model.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();
    Long subscriptionID = 2001L;
    private HashMap<Long, Subscription> mockedSubscriptions = new HashMap<>()
    {{
        put(subscriptionID ,new Subscription(
                "TV service",
                LocalDate.of(2021, 6, 10),
                LocalDate.of(2021, 7,10),
                LocalDate.of(2021, 7,7),
                "active"
        ));
        put(++subscriptionID ,new Subscription(
                "YouSee service",
                LocalDate.of(2021, 5, 8),
                LocalDate.of(2021, 6,8),
                LocalDate.of(2021, 6,5),
                "inactive"
        ));
    }};

    public CustomerRepository() {
        this.customers.add(new Customer(101L, "elonmusk@mars.com","Elon", "Musk", mockedSubscriptions));
    }

    public Long addSubscription(Long customerID, Subscription subscription) {
        try {
            var customer = findCustomerByID(customerID);
            customer.getSubscriptions().put(++subscriptionID, subscription);
            return subscriptionID;
        } catch (NotFoundException e) {
            throw new NotFoundException("Adding subscription failed " + e.getMessage());
        }
    }

    public Map<Long, Subscription> getCustomersSubscriptions (Long customerID) {
            var customer = findCustomerByID(customerID);
            if (customer.getSubscriptions().isEmpty()) {
                throw new NotFoundException("Selected customer has no subscriptions assigned.");
            } else {
                return customer.getSubscriptions();
            }
    }

    public Subscription getSingleSubscription(Long customerID ,Long subscriptionID) {
            var customer = findCustomerByID(customerID);
            if (customer.getSubscriptions().containsKey(subscriptionID)) {
                return customer.getSubscriptions().get(subscriptionID);
            } else {
                throw new NotFoundException("There is no such subscription assigned to the customer.");
            }
    }

    public void deleteSubscription(Long customerID, Long subscriptionID) {
        var customer = findCustomerByID(customerID);
        var removedSubscriptionValue = customer.getSubscriptions().remove(subscriptionID);
        if (removedSubscriptionValue == null) {
            throw new NotFoundException("Deletion failed. Subscription not found.");
        }
    }

    public void changeSubscriptionState(Long customerID, Long subscriptionID, String newState) {
        var customer = findCustomerByID(customerID);
        var subscription = customer.getSubscriptions().get(subscriptionID);
        subscription.setSubscriptionState(newState);
    }

    private Customer findCustomerByID(Long customerID) {
        return customers.stream()
                .filter(customer -> customerID.equals(customer.getCustomerID()))
                .findAny()
                .orElseThrow(()-> new NotFoundException("Customer not found in the database."));
    }
}
