package DSTeam3.source.PearlJam;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import ui.GameInterface;

public class SavageGarden extends PearlJamRestaurant {
    
    private GameInterface gameInterface;
    private boolean reverseOrder;

    public SavageGarden() {
        super("Savage Garden");
        initialiseMenu();
        this.gameInterface = gameInterface;
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
        int dayNumber = gameInterface.getDayCount();
        Queue<Customer> orderQueue = new LinkedList<>(waitingList);
        Queue<Customer> servingOrder = new LinkedList<>(); // To store the serving order

        while (!orderQueue.isEmpty()) {
            int count = 0;
            int queueSize = orderQueue.size();

            while (count < queueSize) {
                Customer customer = orderQueue.poll(); // Remove and retrieve the first person in the queue

                if ((count + 1) % dayNumber == 0) {
                    servingOrder.offer(customer); // Serve the customer first
                } else {
                    orderQueue.offer(customer); // Add the customer back to the queue
                }

                count++;
            }

            if (!servingOrder.isEmpty()) {
                orderQueue.addAll(servingOrder); // Add the customers served first back to the queue
                servingOrder.clear(); // Clear the serving order for the next round
            } else {
                reverseOrder = true;
                reverseOrderQueue(orderQueue); // Reverse the order of the remaining customers in the queue
            }
        }

        orderProcessingList.addAll(orderQueue); // Add the remaining customers to the processing list
    }

    // Method to reverse remaining orderQueue
    private void reverseOrderQueue(Queue<Customer> queue) {
        LinkedList<Customer> tempList = new LinkedList<>();
        while (!queue.isEmpty()) {
            tempList.push(queue.poll());
        }
        while (!tempList.isEmpty()) {
            queue.offer(tempList.pop());
        }
    }

}
