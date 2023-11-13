package controllers;

import models.entities.Pizza;
import models.enums.PizzaShape;
import views.PizzaView;

public class PizzaController {
  private Pizza pizza;
  private PizzaView pizzaView;

  public PizzaController(PizzaView pizzaView) {
    this.pizzaView = pizzaView;
  }

  public Pizza getPizza() {
    return this.pizza;
  }

  public void setPizza(Pizza pizza) {
    this.pizza = pizza;
  }

  public void initializePizza(String label) {
    double diameter = pizzaView.readDiameter(label);
    double price = pizzaView.readPrice(label);
    setPizza(new Pizza(diameter, price));

    pizza.setPizzaShape(PizzaShape.CIRCLE);
    displayInfo(pizza, label + " on Normal Day");

    pizza.setPizzaShape(PizzaShape.SQUARE);
    displayInfo(pizza, label + " on Sunday");
  }

  private void displayInfo(Pizza pizza, String label) {
    double calculateArea = pizza.calculatePizzaArea();
    double calculateRatio = pizza.calculatePriceToAreaRatio();
    pizzaView.displayAreaAndRatio(calculateArea, calculateRatio, label);
  }

  public void displayComparisonResult(double ratioDifferenceNormalDay, double ratioDifferenceSunday,
      String betterDeal) {
    pizzaView.displayPriceAreaRatioDifference(ratioDifferenceNormalDay, "normal day");
    pizzaView.displayPriceAreaRatioDifference(ratioDifferenceSunday, "Sunday");
    pizzaView.displayBetterDealMessage(betterDeal + " pizza is a better deal on Sunday.");
  }
}