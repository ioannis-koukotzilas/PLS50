package views;

import java.util.Scanner;

public class PizzaView {
  private Scanner scanner = new Scanner(System.in);

  public double readDiameter(String label) {
    System.out.printf("Enter the diameter/side of %s (in cm): ", label);
    return scanner.nextDouble();
  }

  public double readPrice(String label) {
    System.out.printf("Enter the price of %s (in euros): ", label);
    return scanner.nextDouble();
  }

  public void displayAreaAndRatio(double pizzaArea, double pizzaRatio, String label) {
    System.out.printf("%s: Area = %.2f cm², Price/Area Ratio = %.2f\n", label, pizzaArea, pizzaRatio);
  }

  public void displayPriceAreaRatioDifference(double absoluteDifference, String dayContext) {
    System.out.printf("Absolute difference between the first and second pizza in Price/Area Ratio on %s: %.2f\n",
        dayContext, absoluteDifference);
  }

  public void displayBetterDealMessage(String message) {
    System.out.println(message);
  }

  public void displayMessage(String message) {
    System.out.println(message);
  }
}