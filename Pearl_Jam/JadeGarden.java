package Pearl_Jam;

public class JadeGarden extends Restaurant{
    public JadeGarden() {
        super("Jade Garden");
        initialiseMenu();
    }

    public void initialiseMenu() {
        menu.add("Braised Chicken in Black Bean Sauce ($15.00)");
        menu.add("Braised Goose Web with Vermicelli ($21.00)");
        menu.add("Deep-fried Hiroshima Oysters ($17.00)");
        menu.add("Poached Tofu with Dried Shrimps ($12.00)");
        menu.add("Scrambled Egg White with Milk ($10.00)");
    }

    // Implementation of Restaurant's abstract processOrders method
    // First and last customers to arrive are served first
    // Followed by second and second last, and so on
    public void processOrders() {

        for (int i = 0; i < waitingList.size() / 2; i++) {
            Customer firstCustomer = waitingList.get(i);
            Customer lastCustomer = waitingList.get(waitingList.size() - 1 - i);

            orderProcessingList.add(firstCustomer);
            orderProcessingList.add(lastCustomer);
        }

        // If the number of customers is odd, add the middle customer to the end of processing list
        if (waitingList.size() % 2 != 0) {
            int middleIndex = waitingList.size() / 2;
            Customer middleCustomer = waitingList.get(middleIndex);
            orderProcessingList.add(middleCustomer);
        }
    }
}
