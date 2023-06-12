package source.Pearl_Jam;
import java.util.Comparator;
import java.util.PriorityQueue;
import DSTeam3.ui.GameInterface;

public class SavageGarden extends Restaurant {
    protected static boolean reverseOrder;

    public SavageGarden() {
        super("Savage Garden");
        initialiseMenu();
        reverseOrder = false;
    }

    private void initialiseMenu() {
        menu.add("Abbacchio’s Tea ($1.00)");
        menu.add("DIO’s Bread ($36.14)");
        menu.add("Giorno’s Donuts ($6.66)");
        menu.add("Joseph’s Tequila ($35.00)");
        menu.add("Kakyoin’s Cherry ($3.50)");
        menu.add("Kakyoin’s Porridge ($4.44)");
    }

    public void addCustomerToWaitingList(Customer customer) {
        customer.setNameRestaurant("Savage Garden");
        waitingList.add(customer);
    }

    // Each person in queue is asked to say a number from 1, starting from the first person
    // If number matches the day number, the person is served first
    // The next person start over from 1
    // If reach end of queue, we start over from the last person and move in reverse order
    @Override
    public void processOrders() {
        int dayNumber = getDayCount();

        // Create a PriorityQueue with a custom comparator
        PriorityQueue<Customer> orderQueue = new PriorityQueue<>(new SavageGardenComparator());

        // Add all customers from waitingList to orderQueue
        orderQueue.addAll(waitingList);

        // Clear the waitingList and orderProcessingList
        waitingList.clear();
        orderProcessingList.clear();

        while (!orderQueue.isEmpty()) {
            Customer customer = orderQueue.poll();
            orderProcessingList.add(customer);
        }
    }

    // Custom comparator for PriorityQueue based on Savage Garden's system
    private static class SavageGardenComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            int dayNumber = getDayCount();

            int c1Number = c1.getOrderNumber();
            int c2Number = c2.getOrderNumber();

            if (reverseOrder) {
                c1Number = -c1Number;
                c2Number = -c2Number;
            }

            int c1Remainder = (c1Number % dayNumber == 0) ? dayNumber : c1Number % dayNumber;
            int c2Remainder = (c2Number % dayNumber == 0) ? dayNumber : c2Number % dayNumber;

            return Integer.compare(c1Remainder, c2Remainder);
        }
    }
}
