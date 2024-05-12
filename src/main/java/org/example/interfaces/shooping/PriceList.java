package org.example.interfaces.shooping;

import org.example.impl.tea.TeaType;
import org.example.interfaces.tea.Tea;

import java.util.HashMap;
import java.util.Map;

public interface PriceList {
  void add(Tea tea, double retailPrice, double wholesalePrice, double wholesaleQuantity);
  void add(Tea tea, double retailPrice);

  double getPrice(Tea tea, double weight);

  static PriceList getPriceList() {
    return new PriceListImpl();
  }
}

class PriceListImpl implements PriceList {
  private Map<TeaType, Map<String, Price>> prices = new HashMap<>();

  @Override
  public void add(Tea tea, double retailPrice, double wholesalePrice, double wholesaleQuantity) {
    Map<String, Price> flavorPrices = prices.computeIfAbsent(tea.getType(), k -> new HashMap<>());
    flavorPrices.put(tea.getFlavor(), new Price(retailPrice, wholesalePrice, wholesaleQuantity));
  }

  @Override
  public void add(Tea tea, double retailPrice) {
    Map<String, Price> flavorPrices = prices.computeIfAbsent(tea.getType(), k -> new HashMap<>());
    flavorPrices.put(tea.getFlavor(), new Price(retailPrice));
  }

  @Override
  public double getPrice(Tea tea, double weight) {
    Map<String, Price> flavorPrices = prices.getOrDefault(tea.getType(), new HashMap<>());
    Price price = flavorPrices.getOrDefault(tea.getFlavor(), new Price(0, 0, 0));
    if (weight <= price.getWholesaleQuantity()) {
      return weight * price.getRetailPrice();
    } else {
      return weight * price.getWholesalePrice();
    }
  }
}

class Price {
  private double retailPrice;
  private double wholesalePrice;
  private double wholesaleQuantity;

  public Price(double retailPrice) {
    this.retailPrice = retailPrice;
  }
  
  public Price(double retailPrice, double wholesalePrice, double wholesaleQuantity) {
    this.retailPrice = retailPrice;
    this.wholesalePrice = wholesalePrice;
    this.wholesaleQuantity = wholesaleQuantity;
  }

  public double getRetailPrice() {
    return retailPrice;
  }

  public double getWholesalePrice() {
    return wholesalePrice;
  }

  public double getWholesaleQuantity() {
    return wholesaleQuantity;
  }
}

