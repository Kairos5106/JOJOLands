package DSTeam3.maps.locations;

import java.util.Comparator;
import java.util.PriorityQueue;

import DSTeam3.source.PearlJam.base.Customer;
import DSTeam3.source.PearlJam.base.PearlJam;

public class JadeGardenRestaurant extends PearlJam{
    public JadeGardenRestaurant(){
        super("Jade Garden");
    }
    
    /*============================================= PEARL JAM =============================================*/

    // COMPUTE ORDER PROCESSING LIST
    // Implementation of processOrders method
    // First and last customers to arrive are served first
    // Followed by the second and second last, and so on
    // public static void processOrders() {
    //     // Create a PriorityQueue to store customers based on arrival time
    //     PriorityQueue<Customer> processingQueue = new PriorityQueue<>(new CustomerComparator());

    //     // Add all customers from waitingList to processingQueue
    //     // Then processingQueue will internally sort the elements according to the priority stated in CustomerComparator
    //     // First customer to arrive at the front of the queue
    //     processingQueue.addAll(pearlJamJadeGarden.getWaitingList());

    //     // Clear the waitingList and orderProcessingList to start with fresh data
    //     pearlJamJadeGarden.getWaitingList().clear();
    //     pearlJamJadeGarden.getOrderProcessingList().clear();

    //     // Retrieve customers from the PriorityQueue in the Jade Garden's system
    //     while (!processingQueue.isEmpty()) {
    //         Customer firstCustomer = processingQueue.poll();
    //         Customer lastCustomer = null;

    //         // Get last customer
    //         if (!processingQueue.isEmpty()) {
    //             lastCustomer = retrieveLastCustomer(processingQueue);
    //         }

    //         // Add the first customer to the orderProcessingList
    //         pearlJamJadeGarden.getOrderProcessingList().add(firstCustomer);

    //         // Add last customer to orderProcessingList
    //         if (lastCustomer != null) {
    //             pearlJamJadeGarden.getOrderProcessingList().add(lastCustomer);
    //         }
    //     }
    // }
    
    // Method to retrieve last customer
    private static Customer retrieveLastCustomer(PriorityQueue<Customer> processingQueue) {
        // Temporarily store the customers to restore the queue later
        PriorityQueue<Customer> tempQueue = new PriorityQueue<>(processingQueue);

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
        processingQueue.addAll(tempQueue);

        return lastCustomer;
    }
    // Custom Comparator class
    // private static class CustomerComparator implements Comparator<Customer> {
    //     @Override
    //     // public int compare(Customer c1, Customer c2) {
    //         // Compare customers based on arrival time
    //         // return c1.getArrivalTime().compareTo(c2.getArrivalTime());
    //     }
    // }

    /*============================================= PEARL JAM =============================================*/
}
