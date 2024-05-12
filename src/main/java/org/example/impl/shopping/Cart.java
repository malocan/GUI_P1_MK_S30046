package org.example.impl.shopping;

import org.example.interfaces.tea.Tea;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  
  private List<Tea> teas;

  public Cart() {
    teas = new ArrayList<>();
  }

  public void add(Tea tea) {
    teas.add(tea);
  }

  public List<Tea> getTeas() {
    return teas;
  }

  public void remove(double amount) {
    double currentAmount = 0;
    for (int i = teas.size() - 1; i >= 0 && currentAmount < amount; i--) {
      Tea tea = teas.get(i);
      double teaAmount = tea.getPrice() * tea.getWeight();
      if (currentAmount + teaAmount <= amount) {
        currentAmount += teaAmount;
        teas.remove(i);
      } else {
        double remainingAmount = amount - currentAmount;
        double remainingWeight = remainingAmount / tea.getPrice();
        Tea updatedTea = tea.withWeight(tea.getWeight() - remainingWeight);
        teas.set(i, updatedTea);
        currentAmount = amount;
      }
    }
  }

  public void empty() {
    teas.clear();
  }

  public double getTotal() {
    double total = 0;
    for (Tea tea : teas) {
      total += tea.getPrice() * tea.getWeight();
    }
    return total;
  }

  public double getTotalWeight() {
    double totalWeight = 0;
    for (Tea tea : teas) {
      totalWeight += tea.getWeight();
    }
    return totalWeight;
  }

  public double getTotalWeightOfTeaWithFlavor(String flavor) {
    double totalWeight = 0;
    for (Tea tea : teas) {
      if (tea.getFlavor().equals(flavor)) {
        totalWeight += tea.getWeight();
      }
    }
    return totalWeight;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Tea tea : teas) {
      sb.append(tea.toString()).append("\n");
    }
    if (teas.isEmpty()) {
      sb.append("-- empty");
    }
    return sb.toString();
  }
}
