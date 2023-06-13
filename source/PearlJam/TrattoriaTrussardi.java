package DSTeam3.source.PearlJam;

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
        customer.setNameRestaurant("Trattoria Trussardi");
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
        // Create a PriorityQueue to store customers based on age and gender
        PriorityQueue<Customer> orderQueue = new PriorityQueue<>(new TrattoriaComparator());
    
        // Add all customers from waitingList to orderQueue
        orderQueue.addAll(waitingList); // addAll from waitingList to orderQueue, then orderQueue will internally sort using TrattoriaComparator
    
        // Clear the waitingList and orderProcessingList
        waitingList.clear();
        orderProcessingList.clear();
    
        // Serve customers in the desired order
        while (!orderQueue.isEmpty()) {
            Customer customer = orderQueue.poll();
            orderProcessingList.add(customer);
        }
    }    
    
    private static class TrattoriaComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            // Handle customers with unspecified ages
            if (c1.getAge() == -1 && c2.getAge() == -1) {
                return 0;
            } else if (c1.getAge() == -1) { // if c2 has age, but c1 no age
                return 1; // c1 is considered greater (comes later)
            } else if (c2.getAge() == -1) { // if c1 has age, but c2 no age
                return -1; // c1 is considered smaller (comes earlier)
            }
    
            // Compare customers based on gender and age
            if (c1.getGender().equalsIgnoreCase("Male") && c2.getGender().equalsIgnoreCase("Female")) {
                return -1; // c1 is considered smaller (comes earlier)
            } else if (c1.getGender().equalsIgnoreCase("Female") && c2.getGender().equalsIgnoreCase("Male")) {
                return 1; // c1 is considered greater (comes later)
            } else if (c1.getGender().equalsIgnoreCase("Male") && c2.getGender().equalsIgnoreCase("Male")) {
                return Integer.compare(c1.getAge(), c2.getAge()); // compare male age in ascending order
            } else if (c1.getGender().equalsIgnoreCase("Female") && c2.getGender().equalsIgnoreCase("Female")) {
                return Integer.compare(c2.getAge(), c1.getAge()); // compare female age in descending order
            }
    
            return 0; // Default case (shouldn't occur)
        }
    }
    
}
