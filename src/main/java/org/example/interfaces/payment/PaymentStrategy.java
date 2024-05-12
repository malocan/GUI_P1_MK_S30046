package org.example.interfaces.payment;

import org.example.impl.customer.Customer;

public interface PaymentStrategy {
  void pay(Customer customer, double amount);
}

