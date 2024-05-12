package org.example.interfaces.payment;

import org.example.impl.customer.Customer;

public interface PaymentMethod {
  double getCommission();
  void pay(Customer customer, double amount);
}
