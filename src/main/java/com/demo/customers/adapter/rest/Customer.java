package com.demo.customers.adapter.rest;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String username;
    private String password;
    private String email;
    private String country;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public static final class CustomerBuilder {
        private UUID id;
        private String username;
        private String password;
        private String email;
        private String country;

        private CustomerBuilder() {
        }

        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
        }

        public CustomerBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public CustomerBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.password = this.password;
            customer.country = this.country;
            customer.username = this.username;
            customer.id = this.id;
            customer.email = this.email;
            return customer;
        }
    }
}
