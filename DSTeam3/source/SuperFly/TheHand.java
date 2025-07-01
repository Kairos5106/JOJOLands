/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.SuperFly;

/**
 *
 * @author firza
 */
import DSTeam3.maps.base.Location;
import DSTeam3.maps.base.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;

public class TheHand {
    private Map map;

    // Constructor
    /**
     * Constructs a new instance of TheHand with the given map.
     *
     * @param map The map object representing the locations and connections.
     */
    public TheHand(Map map) {
        this.map = map;
    }

    /**
     * Finds the total number of connections that can be removed from the map.
     *
     * @return The number of connections that can be removed.
     */
    public int findTotalRemovedConnections() {
        List<String> connections = new ArrayList<>();//store connection between locations

        // Precondition: Assumes that the map and its current location are properly set.

        Location startLocation = map.getCurrentLocation();
        Set<Location> visited = new HashSet<>();//keep track of location that already visited
        PriorityQueue<Location> queue = new PriorityQueue<>(Comparator.comparingInt(location -> location.getDistanceOfNearby().get(0)));
        //based on distance to nearby location, shortest distance will have highest priority
        int totalConnections = 0;//keep track of connection discovered
        int connectionsAfterRemoval = 0;//num of connection to be removed

        visited.add(startLocation);
        queue.add(startLocation);

        while (!queue.isEmpty()) {
            Location current = queue.poll();//Retrieve and remove the location with the shortest distance from the priority queue

            for (int i = 0; i < current.getDistanceOfNearby().size(); i++) {//getnearbylocation distnace
                Location nearby = current.getNearbyLocations().get(i);
                int distance = current.getDistanceOfNearby().get(i);

                if (!visited.contains(nearby)) {//if there new nearby location that not visited yet
                    visited.add(nearby);
                    queue.add(nearby);
                    totalConnections++;
                    String connection = current.getName() + " --- " + nearby.getName() +
                                        " (" + distance + " km)";
                    connections.add(connection);
                }
            }
        }

        // Postcondition: Returns the number of connections that can be removed.
        printConnections(connections);
        return totalConnections - connectionsAfterRemoval;
    }

    /**
     * Prints the unnecessary water connections to be removed.
     *
     * @param connections The list of connections to be printed.
     */
    private void printConnections(List<String> connections) {
        System.out.println("Unnecessary Water Connections to be Removed:");

        // Preprocessing: Initializes the count for numbering the connections.
        int count = 1;

        for (String connection : connections) {
            System.out.println(count + ". " + connection);
            count++;
        }
    }
}
