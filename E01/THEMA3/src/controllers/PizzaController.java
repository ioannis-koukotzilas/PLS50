package controllers;

import services.PizzaService;
import views.PizzaView;

public class PizzaController {
  private PizzaView pizzaView;
  private PizzaService pizzaService;

  public PizzaController(PizzaView pizzaView) {
    this.pizzaView = pizzaView;
    this.pizzaService = new PizzaService();
  }

  public void processMultiplePizzas() {
    String userResponse;

    do {
      calculateGains();
      calculateLargest();

      userResponse = pizzaView.readRepeatDecision();
    } while (userResponse.equalsIgnoreCase("Y"));
  }

  private void calculateGains() {
    for (int i = 0; i < 5; i++) {
      double diameter = pizzaView.readDiameter(i + 1);
      double price = pizzaView.readPrice(i + 1);

      double areaCircle = pizzaService.calculateCircleArea(diameter);
      double rateCircle = pizzaService.calculateRate(price, areaCircle);

      double areaSquare = pizzaService.calculateSquareArea(diameter);
      double rateSquare = pizzaService.calculateRate(price, areaSquare);

      pizzaService.updateGain(i, Math.abs(rateCircle - rateSquare));
    }
  }

  private void calculateLargest() {
    double[] gains = pizzaService.getGain();
    int largestIndex = -1;
    int secondLargestIndex = -1;
    double largestGain = -1;
    double secondLargestGain = -1;

    for (int i = 0; i < gains.length; i++) {
      if (gains[i] > largestGain) {
        secondLargestGain = largestGain;
        secondLargestIndex = largestIndex;
        largestGain = gains[i];
        largestIndex = i;
      } else if (gains[i] > secondLargestGain && gains[i] != largestGain) {
        secondLargestGain = gains[i];
        secondLargestIndex = i;
      }
    }

    if (largestIndex >= 0) {
      pizzaView.displayLargestGain(largestGain, largestIndex + 1);
    }
    if (secondLargestIndex >= 0) {
      pizzaView.displaySecondLargestGain(secondLargestGain, secondLargestIndex + 1);
    }
  }
}