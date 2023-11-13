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
    int pizzaCount = 5;
    double[] diameters = new double[pizzaCount];
    double[] prices = new double[pizzaCount];

    for (int i = 0; i < pizzaCount; i++) {
      diameters[i] = pizzaView.readDiameter(i + 1);
      prices[i] = pizzaView.readPrice(i + 1);
    }

    double[] gains = pizzaService.processPizzaOrders(diameters, prices);
    calculateLargest(gains);
  }

  private void calculateLargest(double[] gains) {
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