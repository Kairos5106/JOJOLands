/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.SuperFly;

/**
 *
 * @author firza
 */
// RedHotChiliPepper.java
import DSTeam3.maps.base.Location;
import DSTeam3.maps.base.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class RedHotChiliPepper {
    private Map map;

    public RedHotChiliPepper(Map map) {
        this.map = map;
    }

    /**
     * Finds the minimum length of power cables required to connect all locations in the map using a minimum spanning tree algorithm.
     *
     * @return The total distance of the power cables to be upgraded.
     */
    public int findMinimumLength() {
        // Precondition: Assumes that the map and its current location are properly set.

        Location startLocation = map.getCurrentLocation();
        Set<Location> visited = new HashSet<>();
        PriorityQueue<Location> queue = new PriorityQueue<>(Comparator.comparingInt(location -> location.getDistanceOfNearby().get(0)));
        int totalDistance = 0;
        List<String> connections = new ArrayList<>();

        visited.add(startLocation);
        queue.add(startLocation);

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i = 0; i < current.getDistanceOfNearby().size(); i++) {
                Location nearby = current.getNearbyLocations().get(i);
                int distance = current.getDistanceOfNearby().get(i);

                if (!visited.contains(nearby)) {
                    visited.add(nearby);
                    queue.add(nearby);
                    totalDistance += distance;
                    String connection = current.getName() + " --- " + nearby.getName() + " (" + distance + " km)";
                    connections.add(connection);
                }
            }
        }

        printConnections(connections, totalDistance);
        return totalDistance;

        // Post-condition: Returns the total distance of the power cables to be upgraded.
    }

    /**
     * Prints the necessary power cables to be upgraded and the total length of the upgraded connections.
     *
     * @param connections    The list of connections to be printed.
     * @param totalDistance  The total distance of the power cables to be upgraded.
     */
    private void printConnections(List<String> connections, int totalDistance) {
        System.out.println("Necessary Power Cables to be Upgraded:");
        for (int i = 0; i < connections.size(); i++) {
            System.out.println((i + 1) + ". " + connections.get(i));
        }
        System.out.println("\nTotal Length of Upgraded Connections: " + totalDistance + " km");

        // Post-condition: Prints the necessary power cables and the total length of the upgraded connections.
    }
}
