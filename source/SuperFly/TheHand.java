/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.SuperFly;

/**
 *
 * @author firza
 */
import base.*;
import java.util.ArrayList;
import java.util.List;

public class TheHand {
    
    private Map map;

    public TheHand(Map map) {
        this.map = map;
    }

    public int findTotalRemovedConnections() {
        List<String> connections = new ArrayList<>();

        Location currentLocation = map.getCurrentLocation();
        List<Location> nearbyLocations = currentLocation.getNearbyLocations();
        int totalConnections = nearbyLocations.size();
        int connectionsAfterRemoval = 1;

        for (Location nearby : nearbyLocations) {
            String connection = currentLocation.getName() + " --- " + nearby.getName() +
                                " (" + currentLocation.getDistanceOfNearby().get(nearbyLocations.indexOf(nearby)) + " km)";
            connections.add(connection);
        }

        printConnections(connections);
        return totalConnections - connectionsAfterRemoval;
    }

    private void printConnections(List<String> connections) {
        System.out.println("Unnecessary Water Connections to be Removed:");
        int count = 1;
        for (String connection : connections) {
            System.out.println(count + ". " + connection);
            count++;
        }
    }
}
