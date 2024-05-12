package org.example.impl.shopping;

import org.example.impl.utils.TeaDecorator;
import org.example.interfaces.shooping.PriceList;
import org.example.interfaces.tea.Tea;

public class ReturnedTea extends TeaDecorator {
  private double weight;

  public ReturnedTea(Tea tea, double weight) {
    super(tea);
    this.weight = weight;
  }

  @Override
  public double getPrice() {
    return PriceList.getPriceList().getPrice(tea, weight) * weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }

  @Override
  public String toString() {
    return tea.toString() + " (returned " + weight + " kg)";
  }
}

