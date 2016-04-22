package com.vonzhou.springinaction.pizza.flow;

import static com.vonzhou.springinaction.pizza.domain.PaymentType.CREDIT_CARD;
import static org.apache.log4j.Logger.*;

import com.vonzhou.springinaction.pizza.domain.*;
import com.vonzhou.springinaction.pizza.service.CustomerNotFoundException;
import com.vonzhou.springinaction.pizza.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
public class PizzaFlowActions implements Serializable{
    private static final Logger LOGGER = getLogger(PizzaFlowActions.class);

    public Customer lookupCustomer(String phoneNumber)
            throws CustomerNotFoundException {

        System.out.println("----------in pizzaFlowActions lookupCustomer");
        Customer customer = customerService.lookupCustomer(phoneNumber);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException();
        }
    }

    public void addCustomer(Customer customer) {
        LOGGER.warn("TODO: Flesh out the addCustomer() method.");
    }

    public Payment verifyPayment(PaymentDetails paymentDetails) {
        Payment payment = null;
        if (paymentDetails.getPaymentType() == CREDIT_CARD) {
            payment = new CreditCardPayment();
        } else {
            payment = new CashOrCheckPayment();
        }

        return payment;
    }

    public void saveOrder(Order order) {
        LOGGER.warn("TODO: Flesh out the saveOrder() method.");
    }

    public boolean checkDeliveryArea(String zipCode) {
        LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
        return "75075".equals(zipCode);
    }

    @Autowired
    CustomerService customerService;
}
