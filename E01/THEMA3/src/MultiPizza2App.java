import controllers.PizzaController;
import views.PizzaView;

public class MultiPizza2App {
  public static void main(String[] args) {
    PizzaView pizzaView = new PizzaView();
    PizzaController pizzaController = new PizzaController(pizzaView);
    pizzaController.processMultiplePizzas();
  }
}