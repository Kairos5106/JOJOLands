package source.Pearl_Jam;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CafeDeuxMagots extends Restaurant {
    public CafeDeuxMagots() {
        super("Cafe Deux Magots");
        initialiseMenu();
    }

    private void initialiseMenu() {
        menu.add("Sampling Matured Cheese Platter ($23.00)");
        menu.add("Spring Lobster Salad ($35.00)");
        menu.add("Spring Organic Omelette ($23.00)");
        menu.add("Truffle-flavoured Poultry Supreme ($34.00)");
        menu.add("White Asparagus ($26.00)");
    }

    @Override
    public void addCustomerToWaitingList(Customer customer) {
        customer.setNameRestaurant("Cafe Deux Magots");
        waitingList.add(customer);
    }

    // Oldest and youngest get served first
    // Then second oldest and second youngest
    // Those with unknown age will be served last, without any particular order
    @Override
    public void processOrders() {
        PriorityQueue<Customer> processingQueue = new PriorityQueue<>(new AgeComparator());

        // Add customers to the processingQueue
        processingQueue.addAll(waitingList);

        // Clear the waitingList and orderProcessingList to start with fresh data
        waitingList.clear();
        orderProcessingList.clear();

        while (!processingQueue.isEmpty()) {
            Customer oldest = processingQueue.poll();
            Customer youngest = null;

            // Get youngest customer
            if (!processingQueue.isEmpty()) {
                youngest = retrieveYoungestCustomer(processingQueue);
            }

            // Add the oldest customer to the orderProcessingList
            orderProcessingList.add(oldest);

            // Add last customer to orderProcessingList
            if (youngest != null) {
                orderProcessingList.add(youngest);
            }
        }

        // Add the customers with unknown age to the processing list
        orderProcessingList.addAll(processingQueue);
    }

    // Method to retrieve youngest customer
    private Customer retrieveYoungestCustomer(PriorityQueue<Customer> processingQueue) {
        // Temporarily store the customers to restore the queue later
        PriorityQueue<Customer> tempQueue = new PriorityQueue<>(processingQueue);

        Customer youngest = null;
        Customer currentCustomer;

        // Retrieve the last customer from the PriorityQueue
        while (!tempQueue.isEmpty()) {
            currentCustomer = tempQueue.poll();

            // If it's the last customer, update the lastCustomer variable
            if (tempQueue.isEmpty()) {
                youngest = currentCustomer;
            }
        }

        // Restore the original order of customers in the queue
        processingQueue.addAll(tempQueue);

        return youngest;
    }

    // Comparator to sort customers based on age
    private static class AgeComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            // Customers with unknown age are treated as the same
            if (c1.getAge() == -1 && c2.getAge() == -1) {
                return 0;
            } else if (c1.getAge() == -1) {
                return 1; // c1 is considered greater (comes later)
            } else if (c2.getAge() == -1) {
                return -1; // c1 is considered smaller (comes earlier)
            } else {
                // Compare ages in descending order
                return Integer.compare(c2.getAge(), c1.getAge());
            }
        }
    }
}
