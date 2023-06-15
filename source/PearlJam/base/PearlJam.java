package DSTeam3.source.PearlJam.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PearlJam {
    protected String nameRestaurant;
    protected List<Customer> waitingList;
    protected List<Customer> orderProcessingList;
    protected List<String> foodMenu;

    public PearlJam(String nameRestaurant) { // takes the name of a particular restaurant and initialises the instance var
        this.nameRestaurant = nameRestaurant;
        waitingList = new ArrayList<>();
        orderProcessingList = new ArrayList<>();
        foodMenu = new ArrayList<>();
    }

    public void setNameRestaurant(String nameRestaurant){
        this.nameRestaurant = nameRestaurant;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public List<Customer> getWaitingList() {
        return waitingList;
    }

    public List<Customer> getOrderProcessingList() {
        return orderProcessingList;
    }

    public List<String> getMenu() {
        return foodMenu;
    }

    // Method addCustomerToWaitingList 
    // Is an abstract method, means it's not implemented in the 'Restaurant' class itself, but will be implemented in its subclasess
    public void addCustomerToWaitingList(Customer customer) {
        waitingList.add(customer);
    }

    public void processOrders(){} // placeholder
 
    public void displayWaitingListAndOrderProcessingList() {
        System.out.println("======================================================================");
        System.out.println("Restaurant: " + nameRestaurant);
        System.out.println("Waiting List");
        displayCustomers(waitingList);
        System.out.println("Order Processing List");
        displayCustomers(orderProcessingList);
        System.out.println("======================================================================");
    }

    public void displayCustomers(Iterable<Customer> customers) {
        System.out.println("+----+--------------------+-----+--------+-");
        System.out.println("| No | Name               | Age | Gender |");
        System.out.println("+----+--------------------+-----+--------+-");

        int index = 1;
        for (Customer customer : customers) {
            System.out.printf("| %-2d | %-18s | %-3d | %-6s |%n", index++, customer.getNameCustomer(), customer.getAge(), customer.getGender());
        }

        System.out.println("-+-------------------------------------+");
        System.out.println("| Order                               |");
        System.out.println("-+-------------------------------------+");

        for (Customer customer : customers) {
            System.out.println("| " + customer.getOrder());
        }

        System.out.println("-+-------------------------------------+");
    }

    public void displayMenu() {
        System.out.println("Menu");
        System.out.println("+-------------------------------------+");
        for (String item : foodMenu) {
            System.out.println("| " + item + " |");
        }
        System.out.println("+-------------------------------------+");
    }

    /*============================================= PEARL JAM =============================================*/

    // ADD CUSTOMER TO WAITING LIST
    // Directly adds the customer to the waiting list of the Jade Garden
    public void addCustomerToWaitingList(Customer customer) {
        customer.setNameRestaurant("Jade Garden");
        pearlJamJadeGarden.getWaitingList().add(customer);
    }

    // COMPUTE ORDER PROCESSIGN LIST
    // Implementation of processOrders method
    // First and last customers to arrive are served first
    // Followed by the second and second last, and so on
    public static void processOrders() {
        // Create a PriorityQueue to store customers based on arrival time
        PriorityQueue<Customer> processingQueue = new PriorityQueue<>(new CustomerComparator());

        // Add all customers from waitingList to processingQueue
        // Then processingQueue will internally sort the elements according to the priority stated in CustomerComparator
        // First customer to arrive at the front of the queue
        processingQueue.addAll(pearlJamJadeGarden.getWaitingList());

        // Clear the waitingList and orderProcessingList to start with fresh data
        pearlJamJadeGarden.getWaitingList().clear();
        pearlJamJadeGarden.getOrderProcessingList().clear();

        // Retrieve customers from the PriorityQueue in the Jade Garden's system
        while (!processingQueue.isEmpty()) {
            Customer firstCustomer = processingQueue.poll();
            Customer lastCustomer = null;

            // Get last customer
            if (!processingQueue.isEmpty()) {
                lastCustomer = retrieveLastCustomer(processingQueue);
            }

            // Add the first customer to the orderProcessingList
            pearlJamJadeGarden.getOrderProcessingList().add(firstCustomer);

            // Add last customer to orderProcessingList
            if (lastCustomer != null) {
                pearlJamJadeGarden.getOrderProcessingList().add(lastCustomer);
            }
        }
    }
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
    private static class CustomerComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            // Compare customers based on arrival time
            return c1.getArrivalTime().compareTo(c2.getArrivalTime());
        }
    }

    /* [2] View Waiting List and Order Processing List */
    public static void displayWaitingListAndOrderProcessingList() {
        pearlJamJadeGarden.displayWaitingListAndOrderProcessingList();
    }

    /* [3] View Menu */
    public static void displayMenu() {
        pearlJamJadeGarden.displayMenu();
    }

    /*============================================= PEARL JAM =============================================*/
}




