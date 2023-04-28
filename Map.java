package DSTeam3;

import java.util.ArrayList;

/* Purpose: Everything involving the map features such as locations, travelling, etc.. */
public interface Map {
    
}

/* Purpose: Represents a node in the map */
class Location{
    private ArrayList<Location> nearbyLocations = new ArrayList<>(); 
    private int noOfNearby; 
    
    public Location(int noOfNearby){
        this.noOfNearby = noOfNearby;
    }

    /* Class methods */
    /* Adds a nearby location to the location node */
    public void addNearby(){

    }

    public void moveTo(){

    }
}

/* All the maps that will be used in Jojolands is defined here */
class DefaultMap implements Map{
    public static void main(String[] args) {
        System.out.println("running main method of defaultmap");
    }
}

class ParallelMap implements Map{

}

class AlternateMap implements Map{

}