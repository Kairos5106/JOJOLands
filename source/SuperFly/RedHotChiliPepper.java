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
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class RedHotChiliPepper{
    private Map map;

    public RedHotChiliPepper(Map map) {
        this.map = map;
    }

    public int findMinimumLength() {
        PriorityQueue<Location> queue = new PriorityQueue<>(
            Comparator.comparingInt(location -> location.getDistanceOfNearby().get(0)));
        
        Set<Location> visited = new HashSet<>();
        
        queue.add(map.getCurrentLocation());

        int totalDistance = 0;
        List<String> connections = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            Location current = queue.poll();

            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);

            if (!current.getDistanceOfNearby().isEmpty()) {
                totalDistance += current.getDistanceOfNearby().get(0);
                String connection = current.getName() + " --- " + 
                                    current.getNearbyLocations().get(0).getName() +
                                    " (" + current.getDistanceOfNearby().get(0) + " km)";
                connections.add(connection);
            }

            for (Location nearby : current.getNearbyLocations()) {
                if (!visited.contains(nearby)) {
                    queue.add(nearby);
                }
            }
        }

        printConnections(connections);
        return totalDistance;
    }

    private void printConnections(List<String> connections) {
        System.out.println("Necessary Power Cables to be Upgraded:");
        int count = 1;
        for (String connection : connections) {
            System.out.println(count + ". " + connection);
            count++;
        }
    }
}


