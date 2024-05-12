package org.example.impl.payment;

import org.example.impl.customer.Customer;
import org.example.interfaces.payment.PaymentStrategy;

public class CreditCard implements PaymentStrategy {
  @Override
  public void pay(Customer customer, double amount) {
    System.out.println(customer.getName() + " paid " + amount + " PLN by credit card.");
  }
}

