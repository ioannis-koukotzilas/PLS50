import controllers.PizzaController;
import services.PizzaService;
import views.PizzaView;

public class PizzaApp {
  public static void main(String[] args) {
    PizzaView pizzaView = new PizzaView();
    PizzaController pizzaController = new PizzaController(pizzaView);
    PizzaService pizzaService = new PizzaService(pizzaController, pizzaView);

    pizzaService.processPizzaOrderComparison();
  }
}

/*
Pizza: Represents the pizza entity.
PizzaController: Manages the interaction with the Pizza entity.
PizzaService: Orchestrates the overall process and business logic.
PizzaView: Handles user input and output.

Η κλάση Pizza χειρίζεται τις ιδιότητες και τους υπολογισμούς που σχετίζονται με μια πίτσα, συμπεριλαμβανομένης της διαμέτρου, της τιμής και του σχήματος (κύκλος ή τετράγωνο).
Η κλάση PizzaView ζητάει την είσοδο του χρήστη για τη διάμετρο και την τιμή της πίτσας.
Η μέθοδος calculatePizzaArea της κλάσης Pizza υπολογίζει το εμβαδόν με διαφορετικό τρόπο ανάλογα με το σχήμα της πίτσας (κύκλος ή τετράγωνο), το οποίο καθορίζεται από την enum PizzaShape.
Η μέθοδος calculatePriceToAreaRatio της κλάσης Pizza υπολογίζει την αναλογία τιμής προς επιφάνεια.

Η κλάση PizzaService υπολογίζει και εμφανίζει την απόλυτη διαφορά μεταξύ των αναλογιών τιμής προς επιφάνεια δύο πιτσών για μια κανονική ημέρα και μια Κυριακή. Εάν ο χρήστης εισάγει τις ίδιες τιμές, ζητάει επανεισαγωγή.

Η εφαρμογή συγκρίνει ποια ημέρα (κανονική ημέρα ή Κυριακή) προσφέρει καλύτερη προσφορά με βάση τις διαφορές στην αναλογία τιμής προς επιφάνεια και εμφανίζει το αποτέλεσμα.
*/