package Pearl_Jam;
import java.util.Iterator;

public class Libeccio extends Restaurant {
    private int currentPersonIndex;

    public Libeccio() {
        super("Libeccio");
        initializeMenu();
        currentPersonIndex = 0;
    }

    private void initializeMenu() {
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
    public void processOrders() {
        int dayNumber = getDayNumber();
        Iterator<Customer> iterator = waitingList.iterator();

        while (!waitingList.isEmpty()) {
            for (int i = 1; i <= dayNumber; i++) {
                if (!iterator.hasNext()) {
                    iterator = waitingList.iterator(); // Start over from the beginning if end of the queue is reached
                }
                iterator.next(); // Move to the next person in the queue
            }

            if (!iterator.hasNext()) {
                iterator = waitingList.iterator(); // Start over from the beginning if end of the queue is reached
            }
            Customer customer = iterator.next();
            iterator.remove(); // Remove the customer from the queue

            orderProcessingList.add(customer);
        }
    }
}
