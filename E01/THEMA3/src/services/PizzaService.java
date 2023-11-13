package services;

public class PizzaService {
  private double[] gain;

  public PizzaService() {
    gain = new double[5];
  }

  public double calculateCircleArea(double diameter) {
    double radius = diameter / 2.0;
    return Math.PI * radius * radius;
  }

  public double calculateSquareArea(double side) {
    return side * side;
  }

  public double calculateRate(double price, double area) {
    return price / area;
  }

  public void updateGain(int index, double value) {
    if (index >= 0 && index < gain.length) {
      gain[index] = value;
    }
  }

  public double[] getGain() {
    return gain;
  }
}
