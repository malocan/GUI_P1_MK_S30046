package org.example.impl.shopping;

import org.example.impl.utils.TeaDecorator;
import org.example.interfaces.tea.Tea;

public class ReturnedTeaDecorator extends TeaDecorator {
  private double weight;

  public ReturnedTeaDecorator(Tea tea, double weight) {
    super(tea);
    this.weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }

  @Override
  public double getPrice() {
    double originalPrice = tea.getPrice();
    double pricePerKg = originalPrice / tea.getWeight();
    return pricePerKg * weight;
  }
}

