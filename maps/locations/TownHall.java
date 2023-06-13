package DSTeam3.maps.locations;

import DSTeam3.maps.base.*;

/* Location 1 */
public class TownHall extends Location{
    public TownHall(){
        super();
        this.nameOfLocation = "Town Hall";
        this.menu = new TownHallMenu();
    }

    public TownHall(String currentMapName){
        super();
        this.nameOfLocation = "Town Hall";
        this.menu = new TownHallMenu();
        this.currentMapName = currentMapName;
    }

    /* Methods for location: Town Hall */
}
