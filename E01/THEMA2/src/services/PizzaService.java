package services;

import models.entities.Pizza;
import models.enums.PizzaShape;

public class PizzaService {

  private double[] gain = new double[5];

  public double[] processPizzaOrders(double[] diameters, double[] prices) {
    for (int i = 0; i < gain.length; i++) {
      Pizza pizza = new Pizza(diameters[i], prices[i]);

      // Calculate for normal day
      pizza.setPizzaShape(PizzaShape.CIRCLE);
      double normalDayRatio = pizza.calculatePriceToAreaRatio();

      // Calculate for Sunday
      pizza.setPizzaShape(PizzaShape.SQUARE);
      double sundayRatio = pizza.calculatePriceToAreaRatio();

      gain[i] = Math.abs(normalDayRatio - sundayRatio);
    }
    return gain;
  }
}