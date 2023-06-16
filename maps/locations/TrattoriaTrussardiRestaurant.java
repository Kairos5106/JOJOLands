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
     * - third round: second youngest man (currentF youngest man), then second oldest woman (currentF oldest woman)
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
                    maleWaitingList.add(customer);
                }
                else if(customer.getGender().equals("Female")){
                    femaleWaitingList.add(customer);
                }
            }  
        }
        Customer customerNoAge = null;
        for (int i = 0; i < waitingListCopy.size(); i++) {
            customerNoAge = waitingListCopy.get(i);
            if(customerNoAge.getAge().equals("N/A")){
                if(customerNoAge.getGender().equals("Male")){
                    maleWaitingListNoAge.add(customerNoAge);
                }
                else if(customerNoAge.getGender().equals("Female")){
                    femaleWaitingListNoAge.add(customerNoAge);
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
        while(notSorted && !maleWaitingList.isEmpty()) {
            Customer currentM = maleWaitingList.get(maleIndex);
            Customer toCompareM = maleWaitingList.get(maleIndex + 1);
            Customer temp;
            if((Integer.parseInt(currentM.getAge())) > (Integer.parseInt(toCompareM.getAge()))) {
                temp = toCompareM;
                maleWaitingList.set(maleIndex + 1, currentM);
                maleWaitingList.set(maleIndex, temp);
                swappingOccurred = true;
            }
            maleIndex++;
            if(maleIndex == maleWaitingList.size() - 2) {
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
        while(notSorted && !femaleWaitingList.isEmpty()) {
            Customer currentF = femaleWaitingList.get(femaleIndex);
            Customer toCompareF = femaleWaitingList.get(femaleIndex + 1);
            Customer temp;
            if((Integer.parseInt(currentF.getAge())) < (Integer.parseInt(toCompareF.getAge()))) {
                temp = toCompareF;
                femaleWaitingList.set(femaleIndex + 1, currentF);
                femaleWaitingList.set(femaleIndex, temp);
                swappingOccurred = true;
            }
            femaleIndex++;
            if(femaleIndex == femaleWaitingList.size() - 2) {
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
 
        // Retrieve from waiting lists and put it into orderProcessingList
        boolean maleTurn = true;
        boolean femaleTurn = false;
        int maleRound = 0;
        int femaleRound = 0;
        int maleRoundNoAge = 0;
        int femaleRoundNoAge = 0;
        boolean reverse = false;
        int maleRoundReverse = maleWaitingList.size() - 1 ;
        int femaleRoundReverse = femaleWaitingList.size() - 1 ;
        int maleRoundNoAgeReverse = maleWaitingListNoAge.size() - 1 ;
        int femaleRoundNoAgeReverse = femaleWaitingListNoAge.size() - 1 ;

        while (true) {
            if (reverse == false) { // first round is youngest man and oldest woman
                if (maleTurn) {
                    if(!maleWaitingList.isEmpty()) {
                        orderProcessingList.add(maleWaitingList.remove(maleRound));
                        maleRound++;
                        maleTurn = false;
                        femaleTurn = true;
                    } else if (!maleWaitingListNoAge.isEmpty()) {
                        orderProcessingList.add(maleWaitingListNoAge.remove(maleRoundNoAge));
                        maleRoundNoAge++;
                        maleTurn = false;
                        femaleTurn = true;
                    }
                } else if (femaleTurn) {
                    if (!femaleWaitingList.isEmpty()) {
                        orderProcessingList.add(femaleWaitingList.remove(femaleRound));
                        femaleRound++;
                        femaleTurn = false;
                        maleTurn = true;
                    } else if (!femaleWaitingListNoAge.isEmpty()) {
                        orderProcessingList.add(femaleWaitingListNoAge.remove(femaleRoundNoAge));
                        femaleRoundNoAge++;
                        femaleTurn = false;
                        maleTurn = true;
                    }
                }
                reverse = true;
            }
            
            else if (reverse == true) { // second round is oldest man and youngest woman
                if (maleTurn) {
                    if(!maleWaitingList.isEmpty()) {
                        orderProcessingList.add(maleWaitingList.remove(maleRoundReverse));
                        maleRoundReverse--;
                        maleTurn = false;
                        femaleTurn = true;
                    } else if (!maleWaitingListNoAge.isEmpty()) {
                        orderProcessingList.add(maleWaitingListNoAge.remove(maleRoundNoAgeReverse));
                        maleRoundNoAgeReverse--;
                        maleTurn = false;
                        femaleTurn = true;
                    }
                } else if (femaleTurn) {
                    if (!femaleWaitingList.isEmpty()) {
                        orderProcessingList.add(femaleWaitingList.remove(femaleRoundReverse));
                        femaleRoundReverse++;
                        femaleTurn = false;
                        maleTurn = true;
                    } else if (!femaleWaitingListNoAge.isEmpty()) {
                        orderProcessingList.add(femaleWaitingListNoAge.remove(femaleRoundNoAgeReverse));
                        femaleRoundNoAgeReverse++;
                        femaleTurn = false;
                        maleTurn = true;
                    }
                }
                reverse = false;
            }

            if (!maleTurn && !femaleTurn) {
                break;
            }
        }

        setOrderProcessingList(orderProcessingList);
    }
}
