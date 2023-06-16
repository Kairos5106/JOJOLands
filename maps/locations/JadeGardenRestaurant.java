package DSTeam3.maps.locations;

import DSTeam3.source.PearlJam.base.Customer;
import DSTeam3.source.PearlJam.base.PearlJam;
import java.util.*;

public class JadeGardenRestaurant extends PearlJam{
    public JadeGardenRestaurant(){
        super("Jade Garden");
    }
    
    /* Purpose: Sorts the waiting list into an order processing list
     * Pattern: first and last, second and second last, ...
     */
    @Override
    public void generateOrderProcessingList() {
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();

        int frontIndex = 0;
        int backIndex = waitingListCopy.size() - 1;

        while(!waitingListCopy.isEmpty()){
            if(!waitingListCopy.isEmpty()){
                orderProcessingList.add(waitingListCopy.remove(frontIndex));
                backIndex--;
            }
            if(!waitingListCopy.isEmpty()){
                orderProcessingList.add(waitingListCopy.remove(backIndex--));
            }
        }
        setOrderProcessingList(orderProcessingList);
    }
}
