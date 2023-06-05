package source.Pearl_Jam;
import java.util.Iterator;
import java.util.PriorityQueue;
import ui.GameInterface;

public class Libeccio extends Restaurant {

    public Libeccio() {
        super("Libeccio");
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

    // Ask each person in the queue to say a number from 1, starting from the first person in the queue
    // If the number is a multiple of the current day, person is REMOVED from the queue and served last
    // The next person removed is served second last
    @Override
    public void processOrders() {
        int dayNumber = getDayCount();
        PriorityQueue<Customer> orderQueue = new PriorityQueue<>(waitingList);
    
        while (!orderQueue.isEmpty()) {
            for (int i = 1; i <= dayNumber; i++) {
                Customer customer = orderQueue.poll(); // remove and retrieve the first person in the queue
                orderQueue.offer(customer); // add the person back to the end of the queue
    
                if (i % dayNumber == 0) { // customer number is a multiple of dayNumber, should be served last
                    orderQueue.remove(customer); // remove the customer from the queue
                    orderProcessingList.add(customer); // add the customer to the orderProcessingList
                }
            }
        }
    }    
}
