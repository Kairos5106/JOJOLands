package source.Pearl_Jam;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class Restaurant {
    protected String nameRestaurant;
    protected PriorityQueue<Customer> waitingList;
    protected List<Customer> orderProcessingList;
    protected List<String> menu;

    public Restaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
        waitingList = new PriorityQueue<>();
        orderProcessingList = new ArrayList<>();
        menu = new ArrayList<>();
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public PriorityQueue<Customer> getWaitingList() {
        return waitingList;
    }

    public List<Customer> getOrderProcessingList() {
        return orderProcessingList;
    }

    public List<String> getMenu() {
        return menu;
    }

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


