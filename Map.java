package DSTeam3;

import java.util.ArrayList;

/* Purpose: Everything involving the map features such as locations, travelling, etc.. */
public abstract class Map {
    /* Instance variables */
    private String mapName;
    private Location current, previous;

    /* Constructors */
    public Map(String mapName){
        this.mapName = mapName;
        this.current = null; // replace null with town hall variable later
        this.previous = null;
    }
    public Map(String mapName, Location current){ // might need this for save and load feature later
        this.mapName = mapName;
        this.current = current;
        this.previous = null; // edit tis for save/load
    }

    /* Class methods */
    public void moveTo(String nameOfLocation){
        current = current.getNearbyLocation(nameOfLocation);
    }

    public abstract void moveBack();
    public abstract void moveTownHall();
    public abstract void advanceNextDay();
}

/* Purpose: Represents a node in the map */
class Location{
    private String nameOfLocation;
    protected ArrayList<Location> nearbyLocations = new ArrayList<Location>(); 
    
    public Location(String nameOfLocation){
        this.nameOfLocation = nameOfLocation;
    }

    /* Class methods */
    /* Purpose: Adds a nearby location to the location node.
     * Has an overload alternative below
     */
    public void addNearby(Location location){
        nearbyLocations.add(location);
    }

    /* Purpose: Takes an array of nearby location objects to be added to the current location */
    public void addNearby(Location[] location){
        
    }

    /* Gets the number of nearby locations that are accessible */
    public int getNearbyCount(){
        return this.nearbyLocations.size();
    }

    /* Returns the name of the location */
    public String toString(){
        return this.nameOfLocation;
    }

    /* Returns the target location object as listed in nearbyLocations arraylist */
    public Location getNearbyLocation(String targetLocation){
        for (int i = 0; i < nearbyLocations.size(); i++) {
            if(nearbyLocations.get(i).nameOfLocation.equals(targetLocation)){
                return nearbyLocations.get(i);
            }
        }
        return null;
    }
}

/* All the maps that will be used in Jojolands is defined here */
class DefaultMap extends Map{

}

class ParallelMap implements Map{

}

class AlternateMap implements Map{

}