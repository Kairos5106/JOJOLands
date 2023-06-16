package DSTeam3.maps.locations;

import java.util.ArrayList;
import java.util.List;

import DSTeam3.source.PearlJam.base.*;

public class TrattoriaTrussardiRestaurant extends PearlJam{
    public TrattoriaTrussardiRestaurant(){
        super("Trattoria Trussardi");
    }

    /* Pattern: 
     * - youngest man first, oldest woman later (pattern 1)
     * - then: oldest woman first, youngest man later (pattern 0)
     * - uses an arbitrary number to keep track of which pattern to sort customers in
    */
    @Override
    public void generateOrderProcessingList(){
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();
        
        
    }
}
