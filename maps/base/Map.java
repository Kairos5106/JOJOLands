package DSTeam3.maps.base;

import java.util.ArrayList;
import DSTeam3.datastructures.*;
import DSTeam3.ui.base.*;
import DSTeam3.maps.locations.*;
import DSTeam3.maps.base.*;

/* Code specific to the maps are stored in their own respective classes, e.g. code for the default map is in DefaultMap.java */

/* Purpose: Everything involving the map features such as locations, travelling, etc.. */
public class Map {
    /* Instance variables */
    protected String mapName;
    protected Location currentLocation; // keeps track of current location
    protected Stack<Location> previous = new Stack<>(); // keeps track of previous locations: helps with the moveBack() function
    protected ArrayList<Location> locations = new ArrayList<>(); // each location object represents a node in the map

    /* Constructors */
    public Map(){}
    
    public Map(Location currentLocation){ // might need this for save and load feature later
        this.currentLocation = currentLocation;
    }

    /* Methods A: Getter and setter methods */

    public String getMapName(){
        return this.mapName;
    }

    /* Purpose: Returns the Location type object, current */
    public Location getCurrentLocation(){
        return this.currentLocation;
    }

    public void defineAll(){}  // just a placeholder for subclasses to override this method

    public Menu getCurrentMenu(){
        return this.currentLocation.getMenu();
    }

    public void setCurrentLocation(Location location){
        this.currentLocation = location;
    }

    /* Methods B: Display methods */

    /* Methods C: Processing methods */

    /* Purpose: Moves the player to the specified location in String form
     * @param nameOfLocation: name of the location in String form
     */
    public void moveTo(String nameOfLocation){
        Location temp = currentLocation;
        currentLocation = currentLocation.getNearbyLocation(nameOfLocation);
        previous.push(temp);
    }

    public void moveBack(){
        currentLocation = previous.pop();
    }

    /* Purpose: Moves player to the Town Hall */
    public void moveTownHall(){
        moveTo("Town Hall");
    }
}