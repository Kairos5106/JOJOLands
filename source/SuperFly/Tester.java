/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.SuperFly;

/**
 *
 * @author firza
 */
import DSTeam3.maps.DefaultMap;
import DSTeam3.maps.AlternateMap;
import DSTeam3.maps.ParallelMap;

public class Tester {
    public static void main(String[] args) {
    // Create the different map instances
        DefaultMap defaultMap = new DefaultMap();
        defaultMap.defineLocations();

        AlternateMap alternateMap = new AlternateMap();
        alternateMap.defineLocations();

        ParallelMap parallelMap = new ParallelMap();
        parallelMap.defineLocations();

        // Test RedHotChiliPepper with DefaultMap
        RedHotChiliPepper redHotChiliPepper1 = new RedHotChiliPepper(defaultMap);
        int minimumLength1 = redHotChiliPepper1.findMinimumLength();
        System.out.println("DefaultMap - Total Length: " + minimumLength1 + " km");

        // Test RedHotChiliPepper with AlternateMap
        RedHotChiliPepper redHotChiliPepper2 = new RedHotChiliPepper(alternateMap);
        int minimumLength2 = redHotChiliPepper2.findMinimumLength();
        System.out.println("AlternateMap - Total Length: " + minimumLength2 + " km");

        // Test RedHotChiliPepper with ParallelMap
        RedHotChiliPepper redHotChiliPepper3 = new RedHotChiliPepper(parallelMap);
        int minimumLength3 = redHotChiliPepper3.findMinimumLength();
        System.out.println("ParallelMap - Total Length: " + minimumLength3 + " km");

        // Test TheHand with DefaultMap
        TheHand theHand1 = new TheHand(defaultMap);
        int totalRemovedConnections1 = theHand1.findTotalRemovedConnections();
        System.out.println("DefaultMap - Total Removed Connections: " + totalRemovedConnections1);

        // Test TheHand with AlternateMap
        TheHand theHand2 = new TheHand(alternateMap);
        int totalRemovedConnections2 = theHand2.findTotalRemovedConnections();
        System.out.println("AlternateMap - Total Removed Connections: " + totalRemovedConnections2);

        // Test TheHand with ParallelMap
        TheHand theHand3 = new TheHand(parallelMap);
        int totalRemovedConnections3 = theHand3.findTotalRemovedConnections();
        System.out.println("ParallelMap - Total Removed Connections: " + totalRemovedConnections3);
    }
}



