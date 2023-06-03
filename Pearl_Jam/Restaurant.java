package Pearl_Jam;
import java.util.ArrayList;
import java.util.List;

public abstract class Restaurant {
    public String nameRestaurant;
    protected List<Customer> waitingList;
    protected List<Customer> orderProcessingList;
    protected List<String> menu;

    public Restaurant(String nameRestaurant) {
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

    public void displayCustomers(List<Customer> customers) {
        System.out.println("+----+--------------------+-----+--------+-");
        System.out.println("| No | Name               | Age | Gender |");
        System.out.println("+----+--------------------+-----+--------+-");

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.printf("| %-2d | %-18s | %-3d | %-6s |%n", i + 1, customer.getNameCustomer(), customer.getAge(), customer.getGender());
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
