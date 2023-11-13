package views;

import java.util.Scanner;

public class PizzaView {

  private Scanner scanner = new Scanner(System.in);

  public double readDiameter(int pizzaNumber) {
    System.out.printf("Give the diameter/side of Pizza no %d: ", pizzaNumber);
    return scanner.nextDouble();
  }

  public double readPrice(int pizzaNumber) {
    System.out.printf("Give the price of Pizza no %d: ", pizzaNumber);
    return scanner.nextDouble();
  }

  public void displayLargestGain(double gain, int position) {
    System.out.printf("Largest is %f at gain table position %d\n", gain, position);
  }

  public void displaySecondLargestGain(double gain, int position) {
    System.out.printf("Second largest is %f at gain table position %d\n", gain, position);
  }
}