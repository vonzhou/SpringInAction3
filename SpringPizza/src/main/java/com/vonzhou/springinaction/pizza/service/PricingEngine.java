package com.vonzhou.springinaction.pizza.service;


import com.vonzhou.springinaction.pizza.domain.Order;

public interface PricingEngine {
  public float calculateOrderTotal(Order order);
}
