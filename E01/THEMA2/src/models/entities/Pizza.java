package models.entities;

import models.enums.PizzaShape;

public class Pizza {
  private double pizzaDiameter;
  private double pizzaPrice;
  private PizzaShape pizzaShape;

  public Pizza(double pizzaDiameter, double pizzaPrice) {
    this.pizzaDiameter = pizzaDiameter;
    this.pizzaPrice = pizzaPrice;
    this.pizzaShape = PizzaShape.CIRCLE;
  }

  public double getPizzaDiameter() {
    return pizzaDiameter;
  }

  public double getPizzaPrice() {
    return pizzaPrice;
  }

  public PizzaShape getPizzaShape() {
    return pizzaShape;
  }

  public void setPizzaShape(PizzaShape pizzaShape) {
    this.pizzaShape = pizzaShape;
  }

  public double calculatePizzaArea() {
    if (pizzaShape == PizzaShape.CIRCLE) {
      double pizzaRadius = pizzaDiameter / 2.0;
      return Math.PI * pizzaRadius * pizzaRadius;
    } else if (pizzaShape == PizzaShape.SQUARE) {
      return pizzaDiameter * pizzaDiameter;
    }
    return 0;
  }

  public double calculatePriceToAreaRatio() {
    double pizzaArea = calculatePizzaArea();
    return pizzaArea == 0 ? 0 : pizzaPrice / pizzaArea;
  }
}