package DSTeam3;

import java.util.ArrayList;

public abstract class Map {
    private int nodeCount;
    private ArrayList<Node> nodeList = new ArrayList<>();
}

class Node{
    private ArrayList<Location> nearbyLocations = new ArrayList<>(); 
}

class Location{

}

/* All the maps that will be used in Jojolands is defined here */
class DefaultMap extends Map{

}

class ParallelMap extends Map{

}

class AlternateMap extends Map{
    
}