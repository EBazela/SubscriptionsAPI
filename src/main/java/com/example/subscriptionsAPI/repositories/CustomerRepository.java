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
    private HashMap<Long, Subscription> mockedSubscriptions = new HashMap<>()
    {{
        put(subscriptionID ,new Subscription(
                "TV service",
                LocalDate.of(2021, 6, 10),
                LocalDate.of(2021, 7,10),
                LocalDate.of(2021, 7,7),
                "active"
        ));
        put(subscriptionID ,new Subscription(
                "YouSee service",
                LocalDate.of(2021, 5, 8),
                LocalDate.of(2021, 6,8),
                LocalDate.of(2021, 6,5),
                "inactive"
        ));
    }};
    Long subscriptionID = 2001L;

    public CustomerRepository() {
        this.customers.add(new Customer(101L, "elonmusk@mars.com","Elon", "Musk", mockedSubscriptions));
    }

    public RegistrationResult addSubscription(Long customerID, Subscription subscription) {
        try {
            var customer = findCustomerByID(customerID);
            customer.getSubscriptions().put(subscriptionID++, subscription);
            return new RegistrationResult("New subscription added successfully");
        } catch (Exception e) {
            throw new NotFoundException("Adding subscription failed" + e.getCause());
        }
    }

//    public Map<Long, Subscription> getCustomersSubscriptions (Long customerID) {
//        try {
//            var customer = findCustomerByID(customerID);
//            return customer.getSubscriptions();
//        } catch (Exception e) {
//            throw new
//        }
//    }

    private Customer findCustomerByID(Long customerID) {
        return customers.stream()
                .filter(customer -> customerID.equals(customer.getCustomerID()))
                .findAny()
                .orElseThrow(()-> new NotFoundException("Customer not found in the database"));
    }
}
