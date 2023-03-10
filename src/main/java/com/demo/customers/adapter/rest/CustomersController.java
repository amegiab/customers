package com.demo.customers.adapter.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/customers")
public class CustomersController {

    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.CustomerBuilder.aCustomer()
                .withId(UUID.randomUUID())
                .withCountry("Spain")
                .withEmail("app@app.es")
                .withPassword("password")
                .withUsername("username")
                .build());
        customers.add(Customer.CustomerBuilder.aCustomer()
                .withId(UUID.randomUUID())
                .withCountry("Germany")
                .withEmail("app@app.es")
                .withPassword("password1")
                .withUsername("username1")
                .build());
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping(path="/", produces = "application/json")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customerCreated = Customer.CustomerBuilder.aCustomer()
                .withId(UUID.randomUUID())
                .withCountry(customer.getCountry())
                .withEmail(customer.getEmail())
                .withPassword(customer.getPassword())
                .withUsername(customer.getUsername())
                .build();
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}
