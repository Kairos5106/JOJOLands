/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds_assignment;
import java.util.*;
//DIRTY DEEDS DONE CHEAP
import java.util.*;

public class PathFinder {
    private static List<List<Location>> shortestPaths;

    public static void findShortestPaths(Location source, Location destination) {
        shortestPaths = new ArrayList<>();
        List<Location> currentPath = new ArrayList<>();
        currentPath.add(source);
        findPathsHelper(source, destination, currentPath);
        displayShortestPaths();
    }

    private static void findPathsHelper(Location current, Location destination, List<Location> currentPath) {
        if (current == destination) {
            shortestPaths.add(new ArrayList<>(currentPath));
            return;
        }

        List<Neighbour> neighbours = current.getNeighbours();
        for (Neighbour neighbour : neighbours) {
            Location nextLocation = neighbour.getLocation();
            if (!currentPath.contains(nextLocation)) {
                currentPath.add(nextLocation);
                findPathsHelper(nextLocation, destination, currentPath);
                currentPath.remove(nextLocation);
            }
        }
    }

    private static void displayShortestPaths() {
        if (shortestPaths.isEmpty()) {
            System.out.println("No paths found between the source and destination.");
            return;
        }

        System.out.println("Top Three Shortest Paths:");
        shortestPaths.sort(Comparator.comparingInt(PathFinder::calculateTotalDistance).thenComparingInt(List::size));

        for (int i = 0; i < Math.min(shortestPaths.size(), 3); i++) {
            List<Location> path = shortestPaths.get(i);
            int totalDistance = calculateTotalDistance(path);
            System.out.println((i + 1) + ". " + formatPath(path) + " (" + totalDistance + " km)");
        }
    }

    private static int calculateTotalDistance(List<Location> path) {
        int totalDistance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Location current = path.get(i);
            Location next = path.get(i + 1);
            for (Neighbour neighbour : current.getNeighbours()) {
                if (neighbour.getLocation() == next) {
                    totalDistance += neighbour.getDistance();
                    break;
                }
            }
        }
        return totalDistance;
    }

    private static String formatPath(List<Location> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i).getName());
            if (i < path.size() - 1) {
                sb.append(" > ");
            }
        }
        return sb.toString();
    }

    public static void PathFinderMethod(String mapName) {
        Location townHall = new Location("Town Hall");
        Location moriohGrand = new Location("Morioh Grand");
        Location trattoriaTrussardi = new Location("Trattoria Trussardi");
        Location greenDolphin = new Location("Green Dolphin");
        Location libeccio = new Location("Libeccio");
        Location sanGiorgio = new Location("San Giorgio");
        Location jadeGarden = new Location("Jade Garden");
        Location cafeDeux = new Location("Cafe Deux Magots");
        Location joestarMansion = new Location("Joestar Mansion");
        Location dioMansion = new Location("Dio Mansion");
        Location angeloRock = new Location("Angelo Rock");
        Location vineyard = new Location("Vineyard");
        Location savageGarden = new Location("Savage Garden");
        Location polnareffLand = new Location("Polnareff Land");
        Location passioneRestaurant = new Location("Passione Restaurant");

        // Define all the locations and their connections here
        if(mapName.equals("Default Map")){
            townHall.addNeighbour(moriohGrand, 5);
            townHall.addNeighbour(jadeGarden, 5);
            townHall.addNeighbour(cafeDeux, 4);
    
            moriohGrand.addNeighbour(townHall, 5);
            moriohGrand.addNeighbour(jadeGarden, 3);
            moriohGrand.addNeighbour(trattoriaTrussardi, 6);
    
            trattoriaTrussardi.addNeighbour(moriohGrand, 6);
            trattoriaTrussardi.addNeighbour(sanGiorgio, 3);
            trattoriaTrussardi.addNeighbour(greenDolphin, 6);
    
            greenDolphin.addNeighbour(trattoriaTrussardi, 6);
            greenDolphin.addNeighbour(libeccio, 3);
            greenDolphin.addNeighbour(angeloRock, 2);
    
            libeccio.addNeighbour(dioMansion, 2);
            libeccio.addNeighbour(vineyard, 6);
            libeccio.addNeighbour(joestarMansion, 6);
            libeccio.addNeighbour(sanGiorgio, 4);
    
            sanGiorgio.addNeighbour(jadeGarden, 2);
            sanGiorgio.addNeighbour(trattoriaTrussardi, 3);
            sanGiorgio.addNeighbour(libeccio, 4);
    
            jadeGarden.addNeighbour(joestarMansion, 2);
            jadeGarden.addNeighbour(cafeDeux, 3);
            jadeGarden.addNeighbour(sanGiorgio, 2);
            jadeGarden.addNeighbour(moriohGrand, 3);
            jadeGarden.addNeighbour(townHall, 5);
    
            cafeDeux.addNeighbour(polnareffLand, 4);
            cafeDeux.addNeighbour(savageGarden, 4);
            cafeDeux.addNeighbour(jadeGarden, 3);
    
            joestarMansion.addNeighbour(savageGarden, 4);
            joestarMansion.addNeighbour(vineyard, 3);
            joestarMansion.addNeighbour(jadeGarden, 2);
            joestarMansion.addNeighbour(libeccio, 6);
    
            dioMansion.addNeighbour(vineyard, 3);
            dioMansion.addNeighbour(angeloRock, 3);
            dioMansion.addNeighbour(libeccio, 2);
    
            vineyard.addNeighbour(savageGarden, 8);
            vineyard.addNeighbour(joestarMansion, 3);
            vineyard.addNeighbour(dioMansion, 3);
    
            savageGarden.addNeighbour(polnareffLand, 6);
            savageGarden.addNeighbour(vineyard, 8);
            savageGarden.addNeighbour(joestarMansion, 4);
            savageGarden.addNeighbour(cafeDeux, 4);
        }
        else if(mapName.equals("Alternate Map")){
            // Define connections for locations in alternate map
            townHall.addNeighbour(moriohGrand, 2);
            townHall.addNeighbour(greenDolphin, 3);
            townHall.addNeighbour(passioneRestaurant, 7);
            
            moriohGrand.addNeighbour(townHall, 2);
            moriohGrand.addNeighbour(sanGiorgio, 3);
            moriohGrand.addNeighbour(joestarMansion, 4);
            moriohGrand.addNeighbour(greenDolphin, 2);

            trattoriaTrussardi.addNeighbour(joestarMansion, 5);
            trattoriaTrussardi.addNeighbour(greenDolphin, 4);
            trattoriaTrussardi.addNeighbour(passioneRestaurant, 1);
            
            passioneRestaurant.addNeighbour(townHall , 7);
            passioneRestaurant.addNeighbour(trattoriaTrussardi, 1);
            passioneRestaurant.addNeighbour(angeloRock, 6);
            passioneRestaurant.addNeighbour(dioMansion, 2);
            passioneRestaurant.addNeighbour(cafeDeux, 4);

            sanGiorgio.addNeighbour(savageGarden, 6);

            jadeGarden.addNeighbour(angeloRock, 1);
            jadeGarden.addNeighbour(polnareffLand, 2);
            
            cafeDeux.addNeighbour(passioneRestaurant , 4);
            cafeDeux.addNeighbour(vineyard, 4);
            cafeDeux.addNeighbour(dioMansion, 1);
            
            dioMansion.addNeighbour(passioneRestaurant, 2);
            dioMansion.addNeighbour(cafeDeux, 1);
            dioMansion.addNeighbour(polnareffLand, 2);
            
            vineyard.addNeighbour(cafeDeux,4);
            vineyard.addNeighbour(savageGarden, 4);
            
            polnareffLand.addNeighbour(jadeGarden, 2);
            polnareffLand.addNeighbour(dioMansion, 1);
            polnareffLand.addNeighbour(angeloRock, 2);
        }
        else if(mapName.equals("Parallel Map")){
            // Define connections for locations in parallel map
            townHall.addNeighbour(trattoriaTrussardi, 6);
            townHall.addNeighbour(vineyard, 3);
            townHall.addNeighbour(libeccio, 2);
            townHall.addNeighbour(cafeDeux, 4);

            moriohGrand.addNeighbour(joestarMansion, 4);
            moriohGrand.addNeighbour(cafeDeux, 6);

            trattoriaTrussardi.addNeighbour(joestarMansion, 5);
            trattoriaTrussardi.addNeighbour(dioMansion, 4);
            trattoriaTrussardi.addNeighbour(angeloRock, 3);

            greenDolphin.addNeighbour(angeloRock, 8);
            greenDolphin.addNeighbour(dioMansion, 6);

            libeccio.addNeighbour(vineyard, 3);

            sanGiorgio.addNeighbour(joestarMansion, 5);
            sanGiorgio.addNeighbour(savageGarden, 6);

            jadeGarden.addNeighbour(joestarMansion, 3);
            jadeGarden.addNeighbour(cafeDeux, 3);
            jadeGarden.addNeighbour(savageGarden, 4);

            cafeDeux.addNeighbour(polnareffLand, 2);
            cafeDeux.addNeighbour(savageGarden, 5);

            dioMansion.addNeighbour(angeloRock, 1);
        }

        // Prompt the user for source and destination
        Scanner scanner = new Scanner(System.in);
        System.out.print("Source: ");
        String sourceName = scanner.nextLine();
        System.out.print("Destination: ");
        String destinationName = scanner.nextLine();

        // Find the top three shortest paths
        Location source = null;
        Location destination = null;
        for (Location location : Arrays.asList(
                townHall, moriohGrand, trattoriaTrussardi, greenDolphin, libeccio, sanGiorgio,
                jadeGarden, cafeDeux, joestarMansion, dioMansion, angeloRock, vineyard,
                savageGarden, polnareffLand)) {
            if (location.getName().equalsIgnoreCase(sourceName)) {
                source = location;
            }
            if (location.getName().equalsIgnoreCase(destinationName)) {
                destination = location;
            }
        }

        if (source != null && destination != null) {
            findShortestPaths(source, destination);
        } else {
            System.out.println("Invalid source or destination location.");
        }
    }
}

