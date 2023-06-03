package Pearl_Jam;

public class SavageGarden extends Restaurant {
    private int currentPersonIndex;
    private boolean reverseOrder;

    public SavageGarden() {
        super("Savage Garden");
        initializeMenu();
        currentPersonIndex = 0;
        reverseOrder = false;
    }

    private void initializeMenu() {
        menu.add("Abbacchio’s Tea ($1.00)");
        menu.add("DIO’s Bread ($36.14)");
        menu.add("Giorno’s Donuts ($6.66)");
        menu.add("Joseph’s Tequila ($35.00)");
        menu.add("Kakyoin’s Cherry ($3.50)");
        menu.add("Kakyoin’s Porridge ($4.44)");
    }

    // Each person in queue is asked to say a number from 1, starting from the first person
    // If number matches the day number, the person is served first
    // The next person start over from 1
    // If reach end of queue, we start over from the last person and move in reverse order
    public void processOrders() {
        int dayNumber = getDayNumber();

        while (!waitingList.isEmpty()) {
            int indexToRemove;
            if (reverseOrder) {
                indexToRemove = (waitingList.size() - dayNumber - currentPersonIndex) % waitingList.size();
            } else {
                indexToRemove = (currentPersonIndex + dayNumber - 1) % waitingList.size();
            }

            Customer customer = waitingList.remove(indexToRemove);
            orderProcessingList.add(customer);

            if (reverseOrder && indexToRemove == waitingList.size()) {
                currentPersonIndex = 0;
                reverseOrder = false;
            } else {
                currentPersonIndex = indexToRemove;
                reverseOrder = true;
            }
        }
    }
}
