package services;

import controllers.PizzaController;
import models.entities.Pizza;
import models.enums.PizzaShape;
import views.PizzaView;

public class PizzaService {
  private PizzaController pizzaController;
  private PizzaView pizzaView;

  public PizzaService(PizzaController pizzaController, PizzaView pizzaView) {
    this.pizzaController = pizzaController;
    this.pizzaView = pizzaView;
  }

  public void processPizzaOrderComparison() {
    Pizza firstPizza = getAndInitializePizza("First Pizza");
    Pizza secondPizza;

    do {
      secondPizza = getAndInitializePizza("Second Pizza");
      if (arePizzasIdentical(firstPizza, secondPizza)) {
        pizzaView.displayMessage("Please enter a different pizza (different diameter/side or price).");
      }
    } while (arePizzasIdentical(firstPizza, secondPizza));

    comparePizzas(firstPizza, secondPizza);
  }

  private Pizza getAndInitializePizza(String label) {
    pizzaController.initializePizza(label);
    return pizzaController.getPizza();
  }

  private boolean arePizzasIdentical(Pizza firstPizza, Pizza secondPizza) {
    return firstPizza.getPizzaDiameter() == secondPizza.getPizzaDiameter()
        && firstPizza.getPizzaPrice() == secondPizza.getPizzaPrice();
  }

  private void comparePizzas(Pizza firstPizza, Pizza secondPizza) {
    // Calculate ratios for normal day
    firstPizza.setPizzaShape(PizzaShape.CIRCLE);
    secondPizza.setPizzaShape(PizzaShape.CIRCLE);
    double firstPizzaRatioNormalDay = firstPizza.calculatePriceToAreaRatio();
    double secondPizzaRatioNormalDay = secondPizza.calculatePriceToAreaRatio();

    // Calculate ratios for Sunday
    firstPizza.setPizzaShape(PizzaShape.SQUARE);
    secondPizza.setPizzaShape(PizzaShape.SQUARE);
    double firstPizzaRatioSunday = firstPizza.calculatePriceToAreaRatio();
    double secondPizzaRatioSunday = secondPizza.calculatePriceToAreaRatio();

    // Calculate and display the absolute differences
    double ratioDifferenceNormalDay = Math.abs(firstPizzaRatioNormalDay - secondPizzaRatioNormalDay);
    double ratioDifferenceSunday = Math.abs(firstPizzaRatioSunday - secondPizzaRatioSunday);

    String betterDeal = ratioDifferenceNormalDay < ratioDifferenceSunday ? "First" : "Second";
    pizzaController.displayComparisonResult(ratioDifferenceNormalDay, ratioDifferenceSunday, betterDeal);
  }
}