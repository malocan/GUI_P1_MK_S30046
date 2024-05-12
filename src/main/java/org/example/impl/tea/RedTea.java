package org.example.impl.tea;

import org.example.interfaces.shooping.PriceList;
import org.example.interfaces.tea.Tea;

public class RedTea implements Tea {
  private static final TeaType TYPE = TeaType.RED;
  private String flavor;
  private double weight;
  private double price;

  public RedTea(double weight) {
    this.weight = weight;
  }

  public RedTea(String flavor, double weight) {
    this.flavor = flavor;
    this.weight = weight;
    this.price = PriceList.getPriceList().getPrice(this, weight);
  }

  @Override
  public TeaType getType() {
    return TYPE;
  }

  @Override
  public String getFlavor() {
    return flavor;
  }

  @Override
  public double getWeight() {
    return weight;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public Tea withWeight(double weight) {
    return new RedTea(weight);
  }

  @Override
  public String toString() {
    return "red, flavor: " + flavor + ", quantity " + weight + " kg, price " + price + " PLN/kg";
  }
}