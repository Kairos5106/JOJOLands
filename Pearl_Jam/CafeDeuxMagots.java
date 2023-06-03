package Pearl_Jam;
import java.util.Comparator;

public class CafeDeuxMagots extends Restaurant {
    public CafeDeuxMagots() {
        super("Cafe Deux Magots");
        initializeMenu();
    }

    private void initializeMenu() {
        menu.add("Sampling Matured Cheese Platter ($23.00)");
        menu.add("Spring Lobster Salad ($35.00)");
        menu.add("Spring Organic Omelette ($23.00)");
        menu.add("Truffle-flavoured Poultry Supreme ($34.00)");
        menu.add("White Asparagus ($26.00)");
    }

    // Oldest and youngest get served first
    // If same age, doesn't matter which one chosen first
    // Those with unkknown age will be served last, without any particular order
    public void processOrders() {

        // Sort customers based on ages in ascending order
        waitingList.sort(Comparator.comparingInt(Customer::getAge));

        int start = 0;
        int end = waitingList.size() - 1;

        while (start < end) {
            Customer youngest = waitingList.get(start);
            Customer oldest = waitingList.get(end);
            orderProcessingList.add(youngest);
            orderProcessingList.add(oldest);
            start++;
            end--;
        }

        // If the number of customers is odd, add the middle customer to the processing list
        if (start == end) {
            orderProcessingList.add(waitingList.get(start));
        }
    }
}
