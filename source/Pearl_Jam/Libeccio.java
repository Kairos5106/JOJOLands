package source.Pearl_Jam;

import java.util.LinkedList;
import java.util.Queue;
import ui.GameInterface;

public class Libeccio extends Restaurant {

    private GameInterface gameInterface;
    
    public Libeccio(GameInterface gameInterface) {
        super("Libeccio");
        this.gameInterface = gameInterface;
        initialiseMenu();
    }

    private void initialiseMenu() {
        menu.add("Formaggio ($12.50)");
        menu.add("Ghiaccio ($1.01)");
        menu.add("Melone ($5.20)");
        menu.add("Prosciutto and Pesci ($20.23)");
        menu.add("Risotto ($13.14)");
        menu.add("Zucchero and Sale ($0.60)");
    }

    // Add customer to waiting list
    public void addCustomerToWaitingList(Customer customer) {
        customer.setNameRestaurant("Libeccio");
        waitingList.add(customer);
    }

    // Ask each person in the queue to say a number from 1, starting from the first person in the queue
    // If the number is a multiple of the current day, person is REMOVED from the queue and served last
    // The next person removed is served second last
    @Override
    public void processOrders() {
        int dayNumber = gameInterface.getDayCount();
        Queue<Customer> orderQueue = new LinkedList<>(waitingList);
        Queue<Customer> servingOrder = new LinkedList<>(); // To store the serving order
        
        while (!orderQueue.isEmpty()) {
            int count = 0;
            int queueSize = orderQueue.size();
            
            while (count < queueSize) {
                Customer customer = orderQueue.poll(); // Remove and retrieve the first person in the queue
                
                if ((count + 1) % dayNumber == 0) {
                    servingOrder.offer(customer); // Serve the customer last
                } else {
                    orderQueue.offer(customer); // Add the customer back to the queue
                }
                
                count++;
            }
            
            orderQueue.addAll(servingOrder); // Add the customers served last back to the queue
            servingOrder.clear(); // Clear the serving order for the next round
        }
        
        orderProcessingList.addAll(orderQueue); // Add the remaining customers to the processing list
    }
}
