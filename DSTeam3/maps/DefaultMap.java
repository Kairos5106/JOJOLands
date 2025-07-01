package DSTeam3.maps;

import DSTeam3.maps.base.*;
import DSTeam3.maps.locations.*;

/* Name: Default Map
 * Number of locations: 14 locations
 * Range of nearby locations: 2 to 5 nearby locations
 */
public class DefaultMap extends Map{
    /* Instance variables */

    /* Menu variables */

    /* Constructors */
    public DefaultMap(){
        super();
        this.mapName = "Default Map";
    }

    public DefaultMap(Location current){
        super(current);
        this.mapName = "Default Map";
    }

    /* Method A: Getter and setter methods */
    
    /* Method B: Display methods */

    /* Method C: Processing methods */

    /* Purpose: Defines all of the location and their respective nearbys in the map */
    @Override
    public void defineLocations(){
        // Define all of the locations present in map
        TownHall townHall = new TownHall(); /* Location 1 */
        MoriohGrand moriohGrand = new MoriohGrand(); /* Location 2 */
        TrattoriaTrussardi trattoriaTrussardi = new TrattoriaTrussardi(); /* Location 3 */
        GreenDolphin greenDolph = new GreenDolphin(); /* Location 4 */
        Libeccio libeccio = new Libeccio(); /* Location 5 */
        SanGiorgio sanGiorgio = new SanGiorgio(); /* Location 6 */
        JadeGarden jadeGarden = new JadeGarden(); /* Location 7 */
        CafeDeux cafeDeux = new CafeDeux(); /* Location 8 */
        JoestarMansion joestarMansion = new JoestarMansion(); /* Location 9 */
        DioMansion dioMansion = new DioMansion(); /* Location 10 */
        AngeloRock angeloRock = new AngeloRock(); /* Location 11 */
        Vineyard vineyard = new Vineyard(); /* Location 12 */
        SavageGarden savageGarden = new SavageGarden(); /* Location 13 */
        PolnareffLand polnareffLand = new PolnareffLand(); /* Location 14 */

        /* Linking the nodes to their respective nearby locations */
        townHall.linkNearby(moriohGrand, 5); // location 1, 3 nearbys
        townHall.linkNearby(jadeGarden, 5);
        townHall.linkNearby(cafeDeux, 4);
        moriohGrand.linkNearby(jadeGarden, 3); // location 2, 2 nearbys
        moriohGrand.linkNearby(trattoriaTrussardi, 6);
        trattoriaTrussardi.linkNearby(sanGiorgio, 3); // location 3, 3 nearbys
        trattoriaTrussardi.linkNearby(greenDolph, 6);
        greenDolph.linkNearby(libeccio, 3); // location 4, 3 nearbys
        greenDolph.linkNearby(angeloRock, 2);
        libeccio.linkNearby(dioMansion, 2); // location 5, 5 nearbys
        libeccio.linkNearby(vineyard, 6);
        libeccio.linkNearby(joestarMansion, 6);
        libeccio.linkNearby(sanGiorgio, 4);
        sanGiorgio.linkNearby(jadeGarden, 2); // location 6, 3 nearbys
        jadeGarden.linkNearby(joestarMansion, 2); // location 7, 5 nearbys 
        jadeGarden.linkNearby(cafeDeux, 3); 
        cafeDeux.linkNearby(polnareffLand, 4); // location 8, 4 nearbys
        cafeDeux.linkNearby(savageGarden, 4);
        joestarMansion.linkNearby(savageGarden, 4); // location 9, 4 nearbys
        joestarMansion.linkNearby(vineyard, 3);
        dioMansion.linkNearby(vineyard, 3); // location 10, 3 nearbys
        dioMansion.linkNearby(angeloRock, 3);
        // location 11 has been fully linked
        vineyard.linkNearby(savageGarden, 8); // location 12, 4 nearbys
        savageGarden.linkNearby(polnareffLand, 6); // location 13, 4 nearbys
        // location 14 has been fully linked

        /* Add all nodes to locations ArrayList to be stored */
        locations.add(townHall); // location 1
        locations.add(moriohGrand); // location 2
        locations.add(trattoriaTrussardi); // location 3
        locations.add(greenDolph); // location 4
        locations.add(libeccio); // location 5
        locations.add(sanGiorgio); // location 6
        locations.add(jadeGarden); // location 7
        locations.add(cafeDeux); // location 8
        locations.add(joestarMansion); // location 9
        locations.add(dioMansion); // location 10
        locations.add(angeloRock); // location 11
        locations.add(vineyard); // location 12
        locations.add(savageGarden); // location 13
        locations.add(polnareffLand); // location 14

        /* Declaring Town Hall as starting point */
        setCurrentLocation(townHall);
    }
}