package DSTeam3.maps.locations;

import java.util.ArrayList;
import java.util.List;

import DSTeam3.source.PearlJam.base.*;

public class TrattoriaTrussardiRestaurant extends PearlJam{
    public TrattoriaTrussardiRestaurant(){
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
    public void generateOrderProcessingList(){
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();
        
        List<Customer> maleWaitingList = new ArrayList<>();
        List<Customer> maleWaitingListNoAge = new ArrayList<>();
        List<Customer> femaleWaitingList = new ArrayList<>();
        List<Customer> femaleWaitingListNoAge = new ArrayList<>();

        // Separate male and female from waiting list into two different arraylist
        Customer customer = null;
        for (int i = 0; i < waitingListCopy.size(); i++) {
            customer = waitingListCopy.get(i);
            if(!customer.getAge().equals("N/A")){
                if(customer.getGender().equals("Male")){
                    maleWaitingList.add(waitingListCopy.get(i));
                }
                else if(customer.getGender().equals("Female")){
                    femaleWaitingList.add(waitingListCopy.get(i));
                }
            }  
        }
        Customer customerNoAge = null;
        for (int i = 0; i < waitingListCopy.size(); i++) {
            customerNoAge = waitingListCopy.get(i);
            if(customerNoAge.getAge().equals("N/A")){
                customer = waitingListCopy.get(i);
                if(customer.getGender().equals("Male")){
                    maleWaitingListNoAge.add(waitingListCopy.get(i));
                }
                else if(customerNoAge.getGender().equals("Female")){
                    femaleWaitingListNoAge.add(waitingListCopy.get(i));
                }
            }  
        }
        /* debug */
        for (int i = 0 ; i < maleWaitingListNoAge.size() ; i++) {
            System.out.println(maleWaitingListNoAge.get(i));
        }
        for (int i = 0 ; i < femaleWaitingListNoAge.size() ; i++) {
            System.out.println(femaleWaitingListNoAge.get(i));
        }

        // Sort maleWaitingList in order of youngest to oldest (bubble sort)
        boolean notSorted = true;
        boolean swappingOccurred = false;
        int maleIndex = 0;
        while(notSorted) {
            Customer current = maleWaitingList.get(maleIndex);
            Customer toCompare = maleWaitingList.get(maleIndex + 1);
            Customer temp;
            if((Integer.parseInt(current.getAge())) > (Integer.parseInt(toCompare.getAge()))) {
                temp = toCompare;
                maleWaitingList.set(maleIndex + 1, current);
                maleWaitingList.set(maleIndex, temp);
                swappingOccurred = true;
            }
            maleIndex++;
            if(maleIndex == maleWaitingList.size() - 1) {
                maleIndex = 0;
                if(swappingOccurred == false){
                    notSorted = false;
                }
                swappingOccurred = false;
            }
        }
        /* debug */
        for (int i = 0 ; i < maleWaitingList.size() ; i++) {
            System.out.println(maleWaitingList.get(i));
        }

        // Sort femaleWaitingList in order of oldest to youngest (bubble sort)
        notSorted = true;
        swappingOccurred = false;
        int femaleIndex = 0;
        while(notSorted) {
            Customer current = femaleWaitingList.get(femaleIndex);
            Customer toCompare = femaleWaitingList.get(femaleIndex + 1);
            Customer temp;
            if((Integer.parseInt(current.getAge())) < (Integer.parseInt(toCompare.getAge()))) {
                temp = toCompare;
                femaleWaitingList.set(femaleIndex + 1, current);
                femaleWaitingList.set(femaleIndex, temp);
                swappingOccurred = true;
            }
            femaleIndex++;
            if(femaleIndex == femaleWaitingList.size() - 1) {
                femaleIndex = 0;
                if(swappingOccurred == false){
                    notSorted = false;
                }
                swappingOccurred = false;
            }
        }
        /* debug */
        for (int i = 0 ; i < femaleWaitingList.size() ; i++) {
            System.out.println(femaleWaitingList.get(i));
        }

        // Retrive from waiting lists and put it into orderProcessingList
        int maleRound = 0;
        int femaleRound = 0;
        boolean maleTurn = true;
        boolean femaleTurn = false;

        while (true) {
            if (maleTurn) {
                if (maleRound < maleWaitingList.size()) {
                    orderProcessingList.add(maleWaitingList.get(maleRound));
                    maleRound++;
                    if (maleRound >= maleWaitingList.size() && femaleRound < femaleWaitingList.size()) {
                        // Only one gender (female) left, choose one person in the next turn
                        maleTurn = false;
                        femaleTurn = true;
                    }
                } else if (maleWaitingListNoAge.size() > 0) {
                    orderProcessingList.add(maleWaitingListNoAge.remove(0));
                } else {
                    maleTurn = false;
                    femaleTurn = true;
                }
            } else if (femaleTurn) {
                if (femaleRound < femaleWaitingList.size()) {
                    orderProcessingList.add(femaleWaitingList.get(femaleRound));
                    femaleRound++;
                    if (femaleRound >= femaleWaitingList.size() && maleRound < maleWaitingList.size()) {
                        // Only one gender (male) left, choose one person in the next turn
                        femaleTurn = false;
                        maleTurn = true;
                    }
                } else if (femaleWaitingListNoAge.size() > 0) {
                    orderProcessingList.add(femaleWaitingListNoAge.remove(0));
                } else {
                    femaleTurn = false;
                    maleTurn = true;
                }
            }

            if (!maleTurn && !femaleTurn) {
                break;
            }
        }

        setOrderProcessingList(orderProcessingList);
    }
}
