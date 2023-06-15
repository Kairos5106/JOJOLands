/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.DDDDC;
import java.util.*;
/**
 *
 * @author Acer
 */
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
        if (current == destination && currentPath.size() > 1) {
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
            System.out.println("No paths found to the destination.");
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

    public static void PathFinderMethod() {
        // Define all the locations and their connections here
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

        townHall.addNeighbour(moriohGrand, 5);
        townHall.addNeighbour(jadeGarden, 5);
        townHall.addNeighbour(cafeDeux, 4);

        moriohGrand.addNeighbour(jadeGarden, 3);
        moriohGrand.addNeighbour(trattoriaTrussardi, 6);

        trattoriaTrussardi.addNeighbour(sanGiorgio, 3);
        trattoriaTrussardi.addNeighbour(greenDolphin, 6);

        greenDolphin.addNeighbour(libeccio, 3);
        greenDolphin.addNeighbour(angeloRock, 2);

        libeccio.addNeighbour(dioMansion, 2);
        libeccio.addNeighbour(vineyard, 6);
        libeccio.addNeighbour(joestarMansion, 6);
        libeccio.addNeighbour(sanGiorgio, 4);

        sanGiorgio.addNeighbour(jadeGarden, 2);

        jadeGarden.addNeighbour(joestarMansion, 2);
        jadeGarden.addNeighbour(cafeDeux, 3);

        cafeDeux.addNeighbour(polnareffLand, 4);
        cafeDeux.addNeighbour(savageGarden, 4);

        joestarMansion.addNeighbour(savageGarden, 4);
        joestarMansion.addNeighbour(vineyard, 3);

        dioMansion.addNeighbour(vineyard, 3);
        dioMansion.addNeighbour(angeloRock, 3);

        vineyard.addNeighbour(savageGarden, 8);

        savageGarden.addNeighbour(polnareffLand, 6);

        // Prompt the user for the destination location
        Scanner scanner = new Scanner(System.in);
        System.out.print("Source: ");
        String sourceName = scanner.nextLine();
        System.out.print("Destination: ");
        String destinationName = scanner.nextLine();

        // Find the top three shortest paths to the destination
        Location source = null;
        Location destination = null;
        for (Location location : Arrays.asList(
                townHall, moriohGrand, trattoriaTrussardi, greenDolphin, libeccio, sanGiorgio,
                jadeGarden, cafeDeux, joestarMansion, dioMansion, angeloRock, vineyard,
                savageGarden, polnareffLand)) {
            if (location.getName().equalsIgnoreCase(destinationName)) {
                destination = location;
                break;
            }
        }

        if (destination != null) {
            findShortestPaths(source, destination);
        } else {
            System.out.println("Invalid destination location.");
        }
    }
         
}