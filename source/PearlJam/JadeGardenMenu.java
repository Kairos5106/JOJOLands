package DSTeam3.source.PearlJam;

import java.util.*;

import DSTeam3.ui.base.*;

public class JadeGardenMenu extends Menu {
    
    private static PearlJamRestaurant pearlJamJadeGarden;
    private static Scanner scanner;
    
    public JadeGardenMenu(){
        this.setLocationName("Jade Garden");
        pearlJamJadeGarden = new PearlJamRestaurant("Jade Garden");
        initialiseMenu();
    }

    public void initialiseMenu() {
        pearlJamJadeGarden.getMenu().add("Braised Chicken in Black Bean Sauce ($15.00)");
        pearlJamJadeGarden.getMenu().add("Braised Goose Web with Vermicelli ($21.00)");
        pearlJamJadeGarden.getMenu().add("Deep-fried Hiroshima Oysters ($17.00)");
        pearlJamJadeGarden.getMenu().add("Poached Tofu with Dried Shrimps ($12.00)");
        pearlJamJadeGarden.getMenu().add("Scrambled Egg White with Milk ($10.00)");
    }

    public static void displayJadeGardenMenu() {
        System.out.println("Current Location: " + pearlJamJadeGarden.getNameRestaurant());
        System.out.println("[1] Move to:");
        System.out.println("[A] Cafe Deux Magots   [B] Joestar Mansion");
        System.out.println("[C] Morioh Grand Hotel [D] San Giorgio Maggiore");
        System.out.println("[E] Town Hall");
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        System.out.println("[6] Back (Town Hall)");
        System.out.println("[7] Back to Town Hall");
        System.out.print("Select: ");
    }

    public static void processUserInput() {
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                System.out.print("Move to: ");
                String location = scanner.nextLine();
                // Process the location movement here
                System.out.println("Moving to " + location);
                break;
            case "A":
                System.out.println("Moving to Cafe Deux Magots");
                break;
            case "B":
                System.out.println("Moving to Joestar Mansion");
                break;
            case "C":
                System.out.println("Moving to Morioh Grand Hotel");
                break;
            case "D":
                System.out.println("Moving to San Giorgio Maggiore");
                break;
            case "E":
                System.out.println("Moving to Town Hall");
                break;
            case "2":
                displayWaitingListAndOrderProcessingList();
                break;
            case "3":
                displayMenu();
                break;
            case "4":
                // View sales information
                break;
            case "5":
                // Perform Milagro Man action
                break;
            case "6":
                System.out.println("Going back to the previous location");
                break;
            case "7":
                System.out.println("Returning to Town Hall");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        // Continue the running process
        processUserInput();
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){        
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        moveTo.addSuboptions("Cafe Deux Magots");
        moveTo.addSuboptions("Joestar Mansion");
        moveTo.addSuboptions("Morioh Grand Hotel");
        moveTo.addSuboptions("San Giorgio Maggiore");
        moveTo.addSuboptions("Town Hall");

        Option viewWaitingList = new Option("View Waiting List and Order Processing List");

        Option viewMenu = new Option("View Menu");

        Option viewSales = new Option("View Sales");
        
        Option milagroMan = new Option("Milagro Man");

        Option backPrevious = new Option("Back to previous location");
        backPrevious.addSuboptions("Yes");
        backPrevious.addSuboptions("No");

        Option backTownHall = new Option("Back to Town Hall");

        Option[] options = {moveTo, viewWaitingList, viewMenu, viewSales, milagroMan, backPrevious, backTownHall};
        setOptions(options);
    }

    /* Purpose: Processes user input and takes the appropriate action depending on which option was selected */
    @Override
    public String execute(String inputStr){
        switch(getSelectedTitle()){
            case "Move to nearby location":
                setGreeting("Select a location to move to: ");
                setOpenMoveLocationsMenu(true);
                break;
            case "Back to Town Hall":
                setMovingLocations(true);
                return "Town Hall";
            case "Back to previous location":
                setReturnPreviousLocation(true);
                break;
            case "Yes":
                setMovingLocations(true);
                break;
            case "No":
                setReturnToFrontPage(true);
                break;
            case "Town Hall":
                setMovingLocations(true);
                return "Town Hall";
            case "Morioh Grand Hotel":
                setMovingLocations(true);
                return "Morioh Grand Hotel";
            case "San Giorgio Maggiore":
                setMovingLocations(true);
                return "San Giorgio Maggiore";
            case "Cafe Deux Magots":
                setMovingLocations(true);
                return "Cafe Deux Magots";
            case "Joestar Mansion":
                setMovingLocations(true);
                return "Joestar Mansion";
            case "Go forward to visited location":
                setMovingLocations(true);
                setWantMoveForward(true);
                break;
            // [2] View Waiting List and Order Processing List
            case "View Waiting List and Order Processing List":
                displayWaitingListAndOrderProcessingList();
                break;
            // [3] View Menu
            case "View Menu":
                displayMenu();
                break;
            // [4] View Sales Information
            case "View Sales Information":
                // fir
                break;
            // [5] Milagro Man
            case "Milagro Man":
                // somen
                break;
        }
        return "";
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


