package DSTeam3.maps;

import java.util.ArrayList;
import DSTeam3.datastructures.Stack;

/* Purpose: Everything involving the map features such as locations, travelling, etc.. */
public abstract class Map {
    /* Instance variables */
    protected String mapName;
    protected Location current;
    protected Stack<Location> previous = new Stack<>();
    protected ArrayList<Location> locations = new ArrayList<>(); // each location object represents a node in the map
    protected TownHall townHall = new TownHall();
    
    /* Constructors */
    public Map(){
        this.current = townHall; // replace null with town hall variable later
    }
    public Map(Location current){ // might need this for save and load feature later
        this.current = current;
    }

    /* Class methods */
    /* Purpose: Moves the player to the specified location in String form
     * @param nameOfLocation: name of the location in String form
     */
    public void moveTo(String nameOfLocation){
        Location temp = current;
        current = current.getNearbyLocation(nameOfLocation);
        previous.push(temp);
    }

    public void moveBack(){
        current = previous.pop();
    }

    /* Purpose: Moves player to the Town Hall */
    public void moveTownHall(){
        moveTo("Town Hall");
    }
}

/* Purpose: Represents a node in the map */
class Location{
    /* Instance variables */
    protected String nameOfLocation;

    /* nearbyLocations and distanceOfNearby are linked in a way.
     * This is as in a nearby object in nearbyLocations arraylist will have the same index as its distance counterpart in
     * distanceOfNearby arraylist
     */
    protected ArrayList<Location> nearbyLocations = new ArrayList<Location>();
    protected ArrayList<Integer> distanceOfNearby = new ArrayList<>(); // distance in kilometers (km)
    
    public Location(){}

    /* Class methods */
    /* Purpose: Two-way links the current location to the nearby location
     */
    public void addNearby(Location location, Integer distanceOfNearby){
        /* Linking current to nearby */
        this.nearbyLocations.add(location);
        this.distanceOfNearby.set(nearbyLocations.indexOf(location), distanceOfNearby);
        /* Linking nearby to current */
        if(location.hasNearby(location)){return;} // stops the function from becoming recursive
        location.addNearby(this, distanceOfNearby);
    }

    /* Purpose: Checks if a location has a nearby location listed already 
     * @return true: if location has a nearby location, false: if a location does not have nearby location
     * @param location: the location object to check for
    */
    public boolean hasNearby(Location location){
        if(this.nearbyLocations.contains(location)){return true;}
        return false;
    }

    /* Gets the number of nearby locations that are accessible */
    public int getNearbyCount(){
        return this.nearbyLocations.size();
    }

    /* Returns the name of the location */
    public String toString(){
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
}

class TownHall extends Location{
    public TownHall(){
        super();
        this.nameOfLocation = "Town Hall";
    }
}

/* Location 2 */
class MoriohGrand extends Location{
    public MoriohGrand(){
        super();
        this.nameOfLocation = "Morioh Grand";
    }
}

/* Location 3 */
class TrattoriaTrussardi extends Location{
    public TrattoriaTrussardi(){
        super();
        this.nameOfLocation = "Trattoria Trussardi";
    }
}

/* Location 4 */
class GreenDolphin extends Location{
    public GreenDolphin(){
        super();
        this.nameOfLocation = "Green Dolphin Street Prison";
    }
}

/* Location 5 */
class Libeccio extends Location{
    public Libeccio(){
        super();
        this.nameOfLocation = "Libeccio";
    }
}

/* Location 5: Replaces Libeccio in Alternate Map */
class PassioneRestaurant extends Location{
    public PassioneRestaurant(){
        super();
        this.nameOfLocation = "Passione Restaurant";
    }
}

/* Location 6 */
class SanGiorgio extends Location{
    public SanGiorgio(){
        super();
        this.nameOfLocation = "San Giorgio Maggiore";
    }
}

/* Location 7 */
class JadeGarden extends Location{
    public JadeGarden(){
        super();
        this.nameOfLocation = "Jade Garden";
    }
}

/* Location 8 */
class CafeDeux extends Location{
    public CafeDeux(){
        super();
        this.nameOfLocation = "Cafe Deux Magots";
    }
}

/* Location 9 */
class JoestarMansion extends Location{
    public JoestarMansion(){
        super();
        this.nameOfLocation = "Joestar Mansion";
    }
}

/* Location 10 */
class DioMansion extends Location{
    public DioMansion(){
        super();
        this.nameOfLocation = "Dio's Mansion";
    }
}

/* Location 11 */
class AngeloRock extends Location{
    public AngeloRock(){
        super();
        this.nameOfLocation = "Angelo Rock";
    }
}

/* Location 12 */
class Vineyard extends Location{
    public Vineyard(){
        super();
        this.nameOfLocation = "Vineyard";
    }
}

/* Location 13 */
class SavageGarden extends Location{
    public SavageGarden(){
        super();
        this.nameOfLocation = "Savage Garden";
    }
}

/* Location 14 */
class PolnareffLand extends Location{
    public PolnareffLand(){
        super();
        this.nameOfLocation = "Polnareff Land";
    }
}