package org.example.impl.customer;


import org.example.impl.shopping.Cart;
import org.example.impl.shopping.ReturnedTeaDecorator;
import org.example.impl.shopping.ShoppingList;
import org.example.interfaces.payment.PaymentStrategy;
import org.example.interfaces.shooping.PriceList;
import org.example.interfaces.tea.Tea;

public class Customer {
  private String name;
  private double funds;
  private ShoppingList shoppingList;
  private Cart cart;

  public Customer(String name, double funds) {
    this.name = name;
    this.funds = funds;
    this.shoppingList = new ShoppingList();
    this.cart = new Cart();
  }

  public void addToShoppingList(Tea tea) {
    shoppingList.add(tea);
  }

  public void repack() {
    cart.empty();
    for (Tea tea : shoppingList.getTeas()) {
      if (PriceList.getPriceList().getPrice(tea, tea.getWeight()) >= 0) {
        cart.add(tea);
      }
    }
  }

  public void pay(PaymentStrategy paymentStrategy) {
    double total = cart.getTotal();
    if (total > funds) {
      double amountToPay = Math.floor(funds / total) * total;
      funds -= amountToPay;
      cart.remove(amountToPay);
    } else {
      funds -= total;
      cart.empty();
    }
    paymentStrategy.pay(this, total);
  }

  public void returnTea(Tea tea, double weight) {
    funds += PriceList.getPriceList().getPrice(tea, weight) * weight;
    Tea returnedTea = new ReturnedTeaDecorator(tea, weight);
    cart.add(returnedTea);
  }

  public String getName() {
    return name;
  }

  public double getFunds() {
    return funds;
  }

  public ShoppingList getShoppingList() {
    return shoppingList;
  }

  public Cart getCart() {
    return cart;
  }
}
