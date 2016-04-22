package com.vonzhou.springinaction.pizza.service;

import com.vonzhou.springinaction.pizza.domain.Order;
import org.apache.log4j.Logger;


public class OrderServiceImpl {
  private static final Logger LOGGER = 
      Logger.getLogger(OrderServiceImpl.class);
  
  public OrderServiceImpl() {}
  
  public void saveOrder(Order order) {
    LOGGER.debug("SAVING ORDER:  " );
    LOGGER.debug("   Customer:  " + order.getCustomer().getName());
    LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
    LOGGER.debug("   Payment:  " + order.getPayment());
  }
}
