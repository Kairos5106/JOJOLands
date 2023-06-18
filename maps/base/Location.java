package DSTeam3.maps.base;

import java.util.ArrayList;
import DSTeam3.ui.base.*;
import DSTeam3.source.MoodyBlues.MoodyBlues;
import DSTeam3.source.PearlJam.base.*;

public /* Purpose: Represents a node in the map */
class Location{
    /* Instance variables */
    protected String nameOfLocation;
    protected Menu menu;
    protected String currentMapName;
    protected PearlJam restaurant;

    /* nearbyLocations and distanceOfNearby are linked in a way as in a nearby object in nearbyLocations arraylist will have the 
     * same index as its distance counterpart in distanceOfNearby arraylist.
     */
    protected ArrayList<Location> nearbyLocations = new ArrayList<Location>();
    protected ArrayList<Integer> distanceOfNearby = new ArrayList<>(); // distance in kilometers (km)
    
    /* Constructor */
    public Location(){}

    public Location(String currentMapName){
        this.currentMapName = currentMapName;
    }
    
    /* Method A: Getter and setter methods */
    /* Purpose: Adds a reference of the nearby location to the current location
     */
    public void addNearby(Location location, Integer distanceOfNearby){
        this.nearbyLocations.add(location);
        this.distanceOfNearby.add(distanceOfNearby);
    }

    /* Purpose: Links two locations to each other
     * @param target: location to link to, distanceBtw: distance between locations
     */
    public void linkNearby(Location target, Integer distanceBtw){
        this.addNearby(target, distanceBtw);
        target.addNearby(this, distanceBtw);
    }

    /* Gets the number of nearby locations that are accessible */
    public int getNearbyCount(){
        return this.nearbyLocations.size();
    }

    /* Returns the name of the location */
    public String getName(){
        return this.nameOfLocation;
    }

    /* Purpose: Takes the string form of a location and returns the target location object as listed in nearbyLocations arraylist
     * @param targetLocation: refers to the 'nameOfLocation' variable of a location object
     */
    public Location getNearbyLocation(String targetLocation){
        for (int i = 0; i < nearbyLocations.size(); i++) {
            if(nearbyLocations.get(i).nameOfLocation.equals(targetLocation)){
                return nearbyLocations.get(i);
            }
        }
        return null;
    }

    public String[] getNearbyLocationNames(){
        String[] nearbyLocationNames = new String[getNearbyCount()];
        for (int i = 0; i < nearbyLocationNames.length; i++) {
            nearbyLocationNames[i] = nearbyLocations.get(i).getName();
        }
        return nearbyLocationNames;
    }

    /* Purpose: Returns the Menu object of the location */
    public Menu getMenu(){
        return this.menu;
    }

    public void setCurrentMapName(String mapName){
        this.currentMapName = mapName;
    }

    public String getCurrentMapName(){
        return this.currentMapName;
    }

    public PearlJam getRestaurant(){
        return this.restaurant;
    }

    public ArrayList<Integer> getDistanceOfNearby(){
        return this.distanceOfNearby;
    }

    /* Returns the arraylist: nearbyLocations */
    public ArrayList<Location> getNearbyLocations(){
        return this.nearbyLocations;
    }

    /* Method B: Display methods */



    /* Method C: Processing methods (everything except A and B) */

    public void defineMenu(){} // placeholder for subclasses to override

    /* Purpose: Checks if a location has a nearby location listed already 
     * @return true: if location has a nearby location, false: if a location does not have nearby location
     * @param location: the location object to check for
    */
    public boolean hasNearby(Location location){
        if(this.nearbyLocations.contains(location)){return true;}
        return false;
    }

    public void displayFoodMenu(){}
}