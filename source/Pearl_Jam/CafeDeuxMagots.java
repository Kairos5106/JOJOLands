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

    // Add customer to waiting list
    public void addCustomerToWaitingList(Customer customer) {
        waitingList.add(customer);
    }

    // Oldest and youngest get served first
    // Then second oldest and second youngest
    // If same age, doesn't matter which one chosen first
    // Those with unknown age will be served last, without any particular order
    @Override
    public void processOrders() {
        PriorityQueue<Customer> waitingQueue = new PriorityQueue<>(Comparator.comparingInt(Customer::getAge));
    
        // Add customers to the waiting queue
        waitingQueue.addAll(waitingList); // addAll waitingList to waitingQueue, then waitingQueue will internally sort in ascending age
    
        // Clear the waitingList and orderProcessingList to start with fresh data
        waitingList.clear();
        orderProcessingList.clear();
        
        PriorityQueue<Customer> orderQueue = new PriorityQueue<>(new AgeComparator());
    
        while (!waitingQueue.isEmpty()) {
            Customer youngest = waitingQueue.poll();
            Customer oldest = retrieveOldest(waitingQueue); // Retrieve the oldest customer
            orderQueue.add(youngest);
            orderQueue.add(oldest);
        }
    
        // If the number of customers is odd, add the middle customer to the processing list
        if (!orderQueue.isEmpty()) {
            Customer middle = orderQueue.poll();
            orderProcessingList.add(middle);
        }
    
        // Add the customers with unknown age to the processing list
        orderProcessingList.addAll(orderQueue);
    }
    
    private Customer retrieveOldest(PriorityQueue<Customer> waitingQueue) {
        // Temporarily store the customers to restore the queue later
        PriorityQueue<Customer> tempQueue = new PriorityQueue<>(waitingQueue);
    
        Customer oldestCustomer = null;
        Customer currentCustomer;
    
        // Retrieve the oldest customer from the PriorityQueue
        while (!tempQueue.isEmpty()) {
            currentCustomer = tempQueue.poll();
    
            // If it's the oldest customer, update the oldestCustomer variable
            if (tempQueue.isEmpty()) {
                oldestCustomer = currentCustomer;
            }
        }
    
        // Restore the original order of customers in the queue
        waitingQueue.addAll(tempQueue);
    
        return oldestCustomer;
    }    

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
                return Integer.compare(c1.getAge(), c2.getAge());
            }
        }
    }
}
