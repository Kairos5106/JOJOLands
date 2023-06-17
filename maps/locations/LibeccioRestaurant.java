package DSTeam3.maps.locations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DSTeam3.source.PearlJam.base.*;
import DSTeam3.ui.GameInterface;

public class LibeccioRestaurant extends PearlJam{
    public LibeccioRestaurant(){
        super("Libeccio");
    }

    /* Pattern: 
     * - each person say number starting from 1
     * - if number is multiple of current day, REMOVE them from queue and served last
     * - the next peson removed is served second last, and so on
     * - if reach end of queue, start over from beginning
    */

    @Override
    public void generateOrderProcessingList(){
        List<Customer> waitingListCopy = getWaitingList();
        List<Customer> orderProcessingList = new ArrayList<>();
        Stack<Customer> stack = new Stack<>();

        // Get day number
        /*GameInterface gameInterface = new GameInterface();
        String dayInfo = gameInterface.getDayInfo();
        System.out.println(dayInfo);
        String[] extractDayNumber = dayInfo.split(" ");
        int dayNumber = Integer.parseInt(extractDayNumber[2]);*/

        int dayNumber = 4;

        // While waitingList is not empty
        // Customer with number same as multiple of dayNumber remove from waiting list and push into stack bcs they'll be served last
        int index = 0;
        while (!waitingListCopy.isEmpty()) {
            int customerNumber = index + 1;

            // If customerNumber is multiple of current day, push to bottom of stack
            if (customerNumber % dayNumber == 0) {
                stack.push(waitingListCopy.remove(index));
            } else {
                index++;
            }

            // Go circular
            if (index == waitingListCopy.size()) {
                index = 0;
            }
        }

        // Pop stack from top into orderProcessingList (he's the first customer that'll be served)
        while (!stack.isEmpty()) {
            orderProcessingList.add(stack.pop());
        }

        setOrderProcessingList(orderProcessingList);
    }
}
