package com.vonzhou.springinaction.pizza.service;

import com.vonzhou.springinaction.pizza.domain.Customer;

public interface CustomerService {
   Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}