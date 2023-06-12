package source.Pearl_Jam;
import java.util.ArrayList;
import java.util.List;

public abstract class Restaurant {
    protected String nameRestaurant;
    protected List<Customer> waitingList;
    protected List<Customer> orderProcessingList;
    protected List<String> menu;

    public Restaurant(String nameRestaurant) { // takes the name of a particular restaurant and initialises the instance var
        this.nameRestaurant = nameRestaurant;
        waitingList = new ArrayList<>();
        orderProcessingList = new ArrayList<>();
        menu = new ArrayList<>();
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
        return menu;
    }

    // Method addCustomerToWaitingList 
    // Is an abstract method, means it's not implemented in the 'Restaurant' class itself, but will be implemented in its subclasess
    public void addCustomerToWaitingList(Customer customer) {
        waitingList.add(customer);
    }

    public abstract void processOrders();

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
}


