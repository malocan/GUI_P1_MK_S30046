package org.example.interfaces.tea;

import org.example.impl.tea.TeaType;

public interface Tea {
  TeaType getType();
  String getFlavor();
  double getWeight();
  double getPrice();
  Tea withWeight(double weight);
}
