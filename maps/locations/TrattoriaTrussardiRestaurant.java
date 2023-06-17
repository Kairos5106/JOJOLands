package DSTeam3.maps.locations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import DSTeam3.source.PearlJam.base.Customer;
import DSTeam3.source.PearlJam.base.PearlJam;

public class TrattoriaTrussardiRestaurant extends PearlJam {
    public TrattoriaTrussardiRestaurant() {
        super("Trattoria Trussardi");
    }

    /* Pattern:
     * - first round: youngest man first, then oldest woman
     * - second round: oldest man, then youngest woman
     * - third round: second youngest man (current youngest man), then second oldest woman (current oldest woman)
     * - if only one gender left, only one person is chosen
     * - customer with unspecified ages will be served last for each gender
     */
    // Note: all people in dataset have gender

    @Override
    public void generateOrderProcessingList() {
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();

        List<Customer> maleWaitingList = new ArrayList<>();
        List<Customer> femaleWaitingList = new ArrayList<>();
        List<Customer> maleWaitingListNoAge = new ArrayList<>();
        List<Customer> femaleWaitingListNoAge = new ArrayList<>();

        // Separate male and female from waiting list into different lists
        for (Customer customer : waitingListCopy) {
            if (customer.getAge().equals("N/A")) {
                if (customer.getGender().equals("Male")) {
                    maleWaitingListNoAge.add(customer);
                } else if (customer.getGender().equals("Female")) {
                    femaleWaitingListNoAge.add(customer);
                }
            } else {
                if (customer.getGender().equals("Male")) {
                    maleWaitingList.add(customer);
                } else if (customer.getGender().equals("Female")) {
                    femaleWaitingList.add(customer);
                }
            }
        }

        // Sort maleWaitingList in order of youngest to oldest
        Collections.sort(maleWaitingList, Comparator.comparingInt(this::parseAge));

        // Sort femaleWaitingList in order of oldest to youngest
        Collections.sort(femaleWaitingList, Comparator.comparingInt(this::parseAge).reversed());

        // Retrieve customers from waiting lists and put them into the orderProcessingList
        boolean maleTurn = true;
        boolean femaleTurn = false;
        int maleIndex = 0;
        int femaleIndex = 0;
        int maleIndexNoAge = 0 ;
        int femaleIndexNoAge = 0;
        boolean reverse = false;

        while (!maleWaitingList.isEmpty() || !femaleWaitingList.isEmpty() ||
                !maleWaitingListNoAge.isEmpty() || !femaleWaitingListNoAge.isEmpty()) {

            if (!maleWaitingList.isEmpty()) {
                orderProcessingList.add(maleWaitingList.get(maleIndex));
                maleIndex++;
                if (maleIndex == maleWaitingList.size()) {
                    maleIndex = 0;
                }
            } else if (!maleWaitingListNoAge.isEmpty()) {
                orderProcessingList.add(maleWaitingListNoAge.get(maleIndexNoAge));
                maleIndexNoAge++;
                if (maleIndexNoAge == maleWaitingListNoAge.size()) {
                    maleIndexNoAge = 0;
                }
            }

            if (!femaleWaitingList.isEmpty()) {
                orderProcessingList.add(femaleWaitingList.get(femaleIndex));
                femaleIndex++;
                if (femaleIndex == femaleWaitingList.size()) {
                    femaleIndex = 0;
                }
            } else if (!femaleWaitingListNoAge.isEmpty()) {
                orderProcessingList.add(femaleWaitingListNoAge.get(femaleIndexNoAge));
                femaleIndexNoAge++;
                if (femaleIndexNoAge == femaleWaitingListNoAge.size()) {
                    femaleIndexNoAge = 0;
                }
            }
        }

        setOrderProcessingList(orderProcessingList);
    }

    private int parseAge(Customer customer) {
        try {
            return Integer.parseInt(customer.getAge());
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE; // Assign a high value for unspecified ages
        }
    }
}
