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
        for (int i=0 ; i<maleWaitingList.size() ; i++) {
            System.out.println(maleWaitingList.get(i));
        }

        // Sort femaleWaitingList in order of oldest to youngest
        Collections.sort(femaleWaitingList, Comparator.comparingInt(this::parseAge).reversed());
        for (int i=0 ; i<femaleWaitingList.size() ; i++) {
            System.out.println(femaleWaitingList.get(i));
        }

        // Retrieve customers from waiting lists and put them into the orderProcessingList
        while (!maleWaitingList.isEmpty() || !femaleWaitingList.isEmpty()) {
            if (!maleWaitingList.isEmpty()) {
                Customer youngestMale = maleWaitingList.get(0);
                orderProcessingList.add(youngestMale);
                maleWaitingList.remove(0);
            }
            if (!femaleWaitingList.isEmpty()) {
                Customer oldestFemale = femaleWaitingList.get(0);
                orderProcessingList.add(oldestFemale);
                femaleWaitingList.remove(0);
            }
            if (!maleWaitingList.isEmpty()) {
                Customer oldestMale = maleWaitingList.get(maleWaitingList.size() - 1);
                orderProcessingList.add(oldestMale);
                maleWaitingList.remove(maleWaitingList.size() - 1);
            }
            if (!femaleWaitingList.isEmpty()) {
                Customer youngestFemale = maleWaitingList.get(femaleWaitingList.size() - 1);
                orderProcessingList.add(youngestFemale);
                femaleWaitingList.remove(femaleWaitingList.size() - 1);
            }
        }

        while (!maleWaitingListNoAge.isEmpty() || !femaleWaitingListNoAge.isEmpty()) {
            if (!maleWaitingListNoAge.isEmpty()) {
                Customer maleNoAge = maleWaitingListNoAge.get(0);
                orderProcessingList.add(maleNoAge);
                maleWaitingListNoAge.remove(0);
            }
            if (!femaleWaitingListNoAge.isEmpty()) {
                Customer femaleNoAge = femaleWaitingListNoAge.get(0);
                orderProcessingList.add(femaleNoAge);
                femaleWaitingListNoAge.remove(0);
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
