package DSTeam3.source.PearlJam.base;

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

    public void addCustomerToWaitingList(Customer customer) {
        waitingList.add(customer);
    }

    public void processOrders(){} // placeholder: to be overridden
 
    public void displayWaitingListAndOrderProcessingList() {
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
        System.out.println(getNameRestaurant() + "\'s Menu");
        System.out.println("+---------------------------------------------------------+");
        for (String[] itemSet : foodMenu) {
            System.out.printf("| %-47s %7s |%n", itemSet[0], "$"+itemSet[1]); // 0 = menu item name, 1 = price
        }
        System.out.println("+---------------------------------------------------------+");
    }

    public List<String[]> getMenuItems(){
        String[][] menuItems = new TheJoestars().getFoodMenu();
        List<String[]> foodMenu = new ArrayList<>();
        for (int i = 0; i < menuItems.length; i++) {
            if(menuItems[i][0].equalsIgnoreCase(getNameRestaurant())){
                String itemName = menuItems[i][1];
                String price = menuItems[i][2];
                foodMenu.add(new String[]{itemName, price});
            }
        }
        return foodMenu;
    }
}




