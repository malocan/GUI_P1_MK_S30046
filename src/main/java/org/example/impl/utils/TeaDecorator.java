package org.example.impl.utils;

import org.example.impl.tea.TeaType;
import org.example.interfaces.tea.Tea;

public abstract class TeaDecorator implements Tea {
  protected Tea tea;

  public TeaDecorator(Tea tea) {
    this.tea = tea;
  }

  @Override
  public TeaType getType() {
    return tea.getType();
  }

  @Override
  public String getFlavor() {
    return tea.getFlavor();
  }

  @Override
  public double getWeight() {
    return tea.getWeight();
  }
}

