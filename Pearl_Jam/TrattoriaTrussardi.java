package Pearl_Jam;
import java.util.Comparator;

public class TrattoriaTrussardi extends Restaurant {
    public TrattoriaTrussardi() {
        super("Trattoria Trussardi");
        initializeMenu();
    }

    private void initializeMenu() {
        menu.add("Caprese Salad ($10.00)");
        menu.add("Creme caramel ($6.50)");
        menu.add("Lamb Chops with Apple Sauce ($25.00)");
        menu.add("Spaghetti alla Puttanesca ($15.00)");
    }

    // Serve youngest man first, followed by oldest woman
    // Next, serve oldest man and then youngest woman
    // If same gender, only one person is chosen in the next turn
    // Customers of unspecified ages will be served last for each gender

    // eg.
    // First round: youngest man, oldest woman
    // Second round: oldest man, youngest woman
    // Third round: second youngest man, second oldest woman
    // Fourth round: second oldest man, second youngest woman
    // And so on...
    public void processOrders() {
    
        // Sort all customer age in ascending order
        waitingList.sort(Comparator.comparingInt(Customer::getAge));
    
        int maleIndex = 0;
        int femaleIndex = waitingList.size() - 1;
    
        while (maleIndex < femaleIndex) {
            Customer youngestMan = findNextCustomerByGenderAndAge("Male", maleIndex);
            Customer oldestWoman = findNextCustomerByGenderAndAge("Female", femaleIndex);
    
            orderProcessingList.add(youngestMan);
            orderProcessingList.add(oldestWoman);
    
            maleIndex++;
            femaleIndex--;
        }
    
        // If there is same gender left in the queue, only one person is chosen in the next turn
        if (maleIndex == femaleIndex) {
            if (maleIndex < waitingList.size()) {
                Customer remainingCustomer = findNextCustomerByGenderAndAge("Male", maleIndex);
                orderProcessingList.add(remainingCustomer);
            } else if (femaleIndex >= 0) {
                Customer remainingCustomer = findNextCustomerByGenderAndAge("Female", femaleIndex);
                orderProcessingList.add(remainingCustomer);
            }
        }
    
        // Serve customers with unspecified ages last for each gender
        serveCustomersWithUnspecifiedAge();

        // Sort the order processing list for next turn
        sortOrderProcessingListByAge();
    }
    
    private void sortOrderProcessingListByAge() {
        orderProcessingList.sort(Comparator.comparingInt(Customer::getAge));
    }

    private void serveCustomersWithUnspecifiedAge() {
        for (Customer customer : waitingList) {
            if (customer.getAge() == -1) {
                orderProcessingList.add(customer);
            }
        }
    }

    private Customer findNextCustomerByGenderAndAge(String gender, int startIndex) {
        for (int i = startIndex; i < waitingList.size(); i++) {
            Customer customer = waitingList.get(i);
            if (customer.getGender().equalsIgnoreCase(gender)) {
                return customer;
            }
        }
        return null;
    }
}
