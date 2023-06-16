package DSTeam3.maps.locations;

import java.util.ArrayList;
import java.util.List;

import DSTeam3.source.PearlJam.base.*;

public class LibeccioRestaurant extends PearlJam{
    public LibeccioRestaurant(){
        super("Libeccio");
    }

    @Override
    public void generateOrderProcessingList(){
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();
        
    }
}
