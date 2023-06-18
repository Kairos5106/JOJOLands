package DSTeam3.maps.locations;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import DSTeam3.source.PearlJam.base.*;
import DSTeam3.ui.GameInterface;

public class SavageGardenRestaurant extends PearlJam{
    public SavageGardenRestaurant(){
        super("Savage Garden");
    }

    /* Pattern: 
     * - each person say number from 1, starting from the first person
     * - if number matches the dayNumber, the person is SERVED FIRST
     * - next person start over from 1
     * - if reach each of queue, start over from last person and move in reverse order
    */

    @Override
    public void generateOrderProcessingList(){
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();
        Queue<Customer> queue = new LinkedList<>();

        // Get day number
        GameInterface gameInterface = new GameInterface();
        String dayInfo = gameInterface.getDayInfo();
        System.out.println(dayInfo);
        String[] extractDayNumber = dayInfo.split(" ");
        int dayNumber = Integer.parseInt(extractDayNumber[2]);

        //int dayNumber = 4;

        // Customer whose number matches the dayNumber will be served first (offer to front of queue)
        int queueSize = waitingListCopy.size();
        int count = 1;
        int forwardIndex = 0;
        int reverseIndex = queueSize - 1;

        while (!waitingListCopy.isEmpty()) {
            if (count == dayNumber) {
                if (forwardIndex <= reverseIndex) {
                    Customer match = waitingListCopy.get(forwardIndex);
                    queue.offer(match);
                    waitingListCopy.remove(forwardIndex);
                    reverseIndex--; // decrement after remove bcs will be used when reverse order
                } else {
                    Customer match = waitingListCopy.get(reverseIndex);
                    queue.offer(match);
                    waitingListCopy.remove(reverseIndex);
                    forwardIndex++;
                }
                count = 1;
                queueSize--;
            } else {
                count++;
                forwardIndex = (forwardIndex + 1) % queueSize;
                reverseIndex = (reverseIndex - 1 + queueSize) % queueSize;
            }
        }

        while (!queue.isEmpty()) {
            orderProcessingList.add(queue.poll());
        }

        setOrderProcessingList(orderProcessingList);
    }
}
