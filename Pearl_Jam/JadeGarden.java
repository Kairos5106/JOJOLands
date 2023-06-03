package Pearl_Jam;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JadeGarden extends Restaurant {
    public JadeGarden() {
        super("Jade Garden");
        initialiseMenu();
    }

    public void initialiseMenu() {
        menu.add("Braised Chicken in Black Bean Sauce ($15.00)");
        menu.add("Braised Goose Web with Vermicelli ($21.00)");
        menu.add("Deep-fried Hiroshima Oysters ($17.00)");
        menu.add("Poached Tofu with Dried Shrimps ($12.00)");
        menu.add("Scrambled Egg White with Milk ($10.00)");
    }

    @Override
    public void addCustomerToWaitingList(Customer customer) {
        waitingList.add(customer);
    }

    // Implementation of Restaurant's abstract processOrders method
    // First and last customers to arrive are served first
    // Followed by the second and second last, and so on
    public void processOrders() {
        // Create a PriorityQueue to store customers based on arrival time
        PriorityQueue<Customer> customerQueue = new PriorityQueue<>(new CustomerComparator());

        // Add all customers from waitingList to PriorityQueue
        customerQueue.addAll(waitingList);

        // Clear the waitingList and orderProcessingList
        waitingList.clear();
        orderProcessingList.clear();

        // Retrieve customers from the PriorityQueue in the Jade Garden's system
        while (!customerQueue.isEmpty()) {
            Customer firstCustomer = customerQueue.poll();
            Customer lastCustomer = null;

            // Get last customer
            if (!customerQueue.isEmpty()) {
                lastCustomer = retrieveLastCustomer(customerQueue);
            }

            // Add the first customer to the orderProcessingList
            orderProcessingList.add(firstCustomer);

            // Add last customer to orderProcessingList
            if (lastCustomer != null) {
                orderProcessingList.add(lastCustomer);
            }
        }
    }

    // Method to retrieve last customer
    private Customer retrieveLastCustomer(PriorityQueue<Customer> customerQueue) {
        // Temporarily store the customers to restore the queue later
        PriorityQueue<Customer> tempQueue = new PriorityQueue<>(customerQueue);

        Customer lastCustomer = null;
        Customer currentCustomer;

        // Retrieve the last customer from the PriorityQueue
        while (!tempQueue.isEmpty()) {
            currentCustomer = tempQueue.poll();

            // If it's the last customer, update the lastCustomer variable
            if (tempQueue.isEmpty()) {
                lastCustomer = currentCustomer;
            }
        }

        // Restore the original order of customers in the queue
        customerQueue.addAll(tempQueue);

        return lastCustomer;
    }

    // Custom Comparator class
    private static class CustomerComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            // Compare customers based on arrival time
            return c1.getArrivalTime().compareTo(c2.getArrivalTime());
        }
    }
}
