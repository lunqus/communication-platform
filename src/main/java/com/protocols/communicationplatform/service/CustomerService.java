package com.protocols.communicationplatform.service;


import com.protocols.communication_platforms.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

    private static final Map<String, Customer> customers  = new HashMap<>();

    @PostConstruct
    public void initialize() {

        Customer microsoft = new Customer();
        microsoft.setName("Microsoft");
        microsoft.setCustId(8080);
        microsoft.setIncome(92000);

        Customer google = new Customer();
        google.setName("Google");
        google.setCustId(8081);
        google.setIncome(99000);

        Customer facebook = new Customer();
        facebook.setName("Facaebook");
        facebook.setCustId(8082);
        facebook.setIncome(101000);


        customers.put(microsoft.getName(), microsoft);
        customers.put(google.getName(), google);
        customers.put(facebook.getName(), facebook);
    }

    public  Customer getCustomers(String name) {
        return customers.get(name);
    }
}
