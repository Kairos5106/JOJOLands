package DSTeam3.maps.locations;

import java.util.ArrayList;
import java.util.List;

import DSTeam3.source.PearlJam.base.*;

public class CafeDeuxRestaurant extends PearlJam{
    public CafeDeuxRestaurant(){
        super("Cafe Deux Magots");
    }

    /* Purpose: Sorts the waiting list into an order processing list
     * Pattern:
     * - oldest and youngest served first in turns
     * - if same age, does not matter which one is chosen
     * - age unknown served last
     */
    @Override
    public void generateOrderProcessingList() {
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();

        while(true){
            // Check if known ages have been fully filtered out of waitingListCopy
            boolean knownAgesSorted = true;
            for (int i = 0; i < waitingListCopy.size(); i++) {
                if(!waitingListCopy.get(i).getAge().equals("N/A")){
                    knownAgesSorted = false;
                    break;
                }    
            }
            if(knownAgesSorted){
                break;
            }

            Customer target;
            Customer oldest = null;
            Customer youngest = null;
            for (int i = 0; i < waitingListCopy.size(); i++) {
                if(i == 0 || oldest.getAge().equals("N/A") || youngest.getAge().equals("N/A")){
                    oldest = youngest = waitingListCopy.get(i);
                }
                target = waitingListCopy.get(i);
                if(target.getAge().equals("N/A")){
                    continue;
                }
                if(Integer.parseInt(oldest.getAge()) < Integer.parseInt(target.getAge())){
                    oldest = target;
                }
                if(Integer.parseInt(youngest.getAge()) > Integer.parseInt(target.getAge())){
                    youngest = target;
                }
            }

            if(waitingListCopy.indexOf(oldest) == waitingListCopy.indexOf(youngest)){
                waitingListCopy.remove(waitingListCopy.indexOf(oldest));
                orderProcessingList.add(oldest);
            }
            else{
                waitingListCopy.remove(waitingListCopy.indexOf(oldest));
                waitingListCopy.remove(waitingListCopy.indexOf(youngest));
                orderProcessingList.add(oldest);
                orderProcessingList.add(youngest);
            }
        }

        for (int i = 0; i < waitingListCopy.size(); i++) {
            orderProcessingList.add(waitingListCopy.get(i));
        }

        setOrderProcessingList(orderProcessingList);
    }
}