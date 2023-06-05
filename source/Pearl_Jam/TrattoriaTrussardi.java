package source.Pearl_Jam;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TrattoriaTrussardi extends Restaurant {
    public TrattoriaTrussardi() {
        super("Trattoria Trussardi");
        initialiseMenu();
    }

    private void initialiseMenu() {
        menu.add("Caprese Salad ($10.00)");
        menu.add("Creme caramel ($6.50)");
        menu.add("Lamb Chops with Apple Sauce ($25.00)");
        menu.add("Spaghetti alla Puttanesca ($15.00)");
    }

    // Add customer to waiting list
    public void addCustomerToWaitingList(Customer customer) {
        waitingList.add(customer);
    }

    // Serve youngest man first, followed by oldest woman
    // Next, serve oldest man and then youngest woman
    // If same gender, only one person is chosen in the next turn
    // Customers of unspecified ages will be served last for each gender

    // eg.
    // First round: youngest man, oldest woman
    // Second round: oldest man, youngest woman
    // Third round: second youngest man, second oldest woman
    // Fourth round: second oldest man, second youngest woman
    // And so on...
    @Override
    public void processOrders() {

    }
    
}
