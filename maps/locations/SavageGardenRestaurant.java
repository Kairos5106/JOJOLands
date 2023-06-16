package DSTeam3.maps.locations;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import DSTeam3.source.PearlJam.base.*;

public class SavageGardenRestaurant extends PearlJam{
    public SavageGardenRestaurant(){
        super("Savage Garden");
    }

    /* Pattern: 
     * - Each person say number from 1, starting from the first person
     * - If number matches the dayNumber, the person is SERVED FIRST
     * - Next person start over from 1
     * - If reach each of queue, start over from last person and move in reverse order
    */

    @Override
    public void generateOrderProcessingList(){
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();
        Queue<Customer> queue = new LinkedList<>();

        // Get day number
        /*GameInterface gameInterface = new GameInterface();
        String dayInfo = gameInterface.getDayInfo();
        System.out.println(dayInfo);
        String[] extractDayNumber = dayInfo.split(" ");
        int dayNumber = Integer.parseInt(extractDayNumber[2]);

        for (int i = 0 ; i < waitingListCopy.size() ; i++) {
            System.out.println(waitingListCopy.get(i));
        }
        System.out.println();*/
        int dayNumber = 4;

        // Customer whose number matches the dayNumber will be served first
        for (int i = 0 ; i < waitingListCopy.size() ; i++) {
            //index %= waitingListCopy.size(); // to reset the value of index to zero when it becomes greater than or equal to the size of the list
            
            int customerNumber = i;

            // If customerNumber matches dayNumber, offer to front of queue
            if ((customerNumber + 1) == dayNumber) {
                queue.offer(waitingListCopy.remove(i));
            }

            // Go circular
            if (i == waitingListCopy.size() - 1) {
                i = 0;
            }
        }

        while (!queue.isEmpty()) {
            orderProcessingList.add(queue.poll());
        }

        setOrderProcessingList(orderProcessingList);
    }
}
