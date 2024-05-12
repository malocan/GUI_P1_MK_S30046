package org.example.impl.shopping;

import org.example.interfaces.tea.Tea;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
  private List<Tea> teas;

  public ShoppingList() {
    teas = new ArrayList<>();
  }

  public void add(Tea tea) {
    teas.add(tea);
  }

  public List<Tea> getTeas() {
    return teas;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Tea tea : teas) {
      sb.append(tea.toString()).append("\n");
    }
    return sb.toString();
  }
}
