package DSTeam3.source.PearlJam.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import DSTeam3.source.Joestars.*;

public class PearlJam {
    protected String nameRestaurant;
    protected List<Customer> waitingList;
    protected List<Customer> orderProcessingList;
    protected List<String[]> foodMenu;

    public PearlJam(String nameRestaurant) { // takes the name of a particular restaurant and initialises the instance var
        this.nameRestaurant = nameRestaurant;
        waitingList = new ArrayList<>();
        orderProcessingList = new ArrayList<>();
        foodMenu = getMenuItems();
    }

    // Accessor and Mutator methods of the instance variables
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

    public List<String[]> getMenu() {
        return foodMenu;
    }

    public void clearWaitingList(){
        this.waitingList.clear();
    }

    public void setOrderProcessingList(List<Customer> orderProcessingList){
        this.orderProcessingList = orderProcessingList;
    }

    public void generateWaitingList(int day) {
        String filePath = (new TheJoestars()).getFilePath();
        clearWaitingList();

        // Adding customers to waiting list from AssignFood.csv
        try{
            Scanner in = new Scanner(new FileInputStream(filePath));
            String line;
            String[] lineElements;

            in.nextLine(); // skip header
            while(in.hasNextLine()){
                line = in.nextLine();
                lineElements = line.split(",");
                if(lineElements[0].equals(Integer.toString(day)) && (lineElements[4].equalsIgnoreCase(getNameRestaurant()))){ // fifth column (index 4) in AssignFood is restaurant name
                    String name = lineElements[1];
                    String age = lineElements[2];
                    String gender = lineElements[3];
                    String order = lineElements[5];
                    int arrivalTime = Integer.parseInt(lineElements[7]);
                    Customer customer = new Customer(name, age, gender, order, arrivalTime);
                    waitingList.add(customer);
                }
            }
            in.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        // Debug for adding customers
        // System.out.println("Successfully added customers to waiting list (size: " + waitingList.size() + "):");
        // for (int i = 0; i < waitingList.size(); i++) {
        //     System.out.println(waitingList.get(i).toString());
        // }

        // Sorting waiting list according to arrival time: bubble sort
        boolean notSorted = true;
        boolean swappingOccured = false;
        int index = 0;
        int epoch = 1; // for debugging below
        while(notSorted){
            Customer current = waitingList.get(index);
            Customer toCompare = waitingList.get(index + 1);
            Customer temp;
            if(current.getArrivalTime() > toCompare.getArrivalTime()){
                temp = toCompare;
                waitingList.set(index + 1, current);
                waitingList.set(index, temp);
                swappingOccured = true;
            }
            index++;
            if(index == waitingList.size() - 1){ // if cycle through list once without any swapping, list is sorted
                index = 0;
                if(swappingOccured == false){
                    notSorted = false;
                }
                swappingOccured = false;
                // Debug
                // System.out.println("List after epoch " + epoch);
                // for (int i = 0; i < waitingList.size(); i++) {
                //     System.out.println(waitingList.get(i).toString());
                // }
            }
        }

        // Waiting list now contains customers sorted in order of arrivalTime (first arrived ot last arrived)
        // Assign waiting list order number for customers
        int orderNumber = 1;
        for (int i = 0; i < waitingList.size(); i++) {
            waitingList.get(i).setOrderNumber(orderNumber++);
        }

        // Debug for sorting customers
        // System.out.println("Successfully sorted customers in waiting list (size: " + waitingList.size() + "):");
        // for (int i = 0; i < waitingList.size(); i++) {
        //     System.out.println(waitingList.get(i).toString());
        // }
    }

    public void generateOrderProcessingList(){} // placeholder: to be overridden

    public void displayWaitingList(){
        System.out.println("Restaurant: " + nameRestaurant);
        System.out.println();
        System.out.println("Waiting List");
        displayCustomers(waitingList);
        System.out.println();
    }

    public void displayOrderProcessingList(){
        System.out.println("Order Processing List");
        displayCustomers(orderProcessingList);
        System.out.println();
    }

    public void displayCustomers(Iterable<Customer> customers) {
        System.out.println("+----+-------------------------+-----+--------+---------------------------------------------+");
        System.out.println("| No | Name                    | Age | Gender | Order                                       |");
        System.out.println("+----+-------------------------+-----+--------+---------------------------------------------+");

        int index = 1;
        for (Customer customer : customers) {
            System.out.printf("| %-2d | %-23s | %-3s | %-6s | %-43s |%n", index++, customer.getNameCustomer(), customer.getAge(), customer.getGender(), customer.getOrder());
        }

        System.out.println("+----+-------------------------+-----+--------+---------------------------------------------+");
    }

    /* Purpose: Displays the food menu for the current restaurant */
    public void displayMenu() {
        System.out.println(getNameRestaurant() + "\'s Menu");
        System.out.println("+---------------------------------------------------------+");
        for (String[] itemSet : foodMenu) {
            System.out.printf("| %-47s %7s |%n", itemSet[0], "$"+itemSet[1]); // 0 = menu item name, 1 = price
        }
        System.out.println("+---------------------------------------------------------+");
    }

    /* Purpose: Gets the menu items specific to a restaurant */
    public List<String[]> getMenuItems(){
        List<String[]> menuItems = (new TheJoestars()).getFoodMenu();
        List<String[]> foodMenu = new ArrayList<>();
        for (int i = 0; i < menuItems.size(); i++) {
            if(menuItems.get(i)[0].equalsIgnoreCase(getNameRestaurant())){
                String itemName = menuItems.get(i)[1];
                String price = menuItems.get(i)[2];
                foodMenu.add(new String[]{itemName, price});
            }
        }
        return foodMenu;
    }
}




