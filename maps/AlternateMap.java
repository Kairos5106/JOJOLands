package DSTeam3.maps;

import DSTeam3.maps.base.*;
import DSTeam3.maps.locations.AngeloRock;
import DSTeam3.maps.locations.CafeDeux;
import DSTeam3.maps.locations.DioMansion;
import DSTeam3.maps.locations.GreenDolphin;
import DSTeam3.maps.locations.JadeGarden;
import DSTeam3.maps.locations.JoestarMansion;
import DSTeam3.maps.locations.Libeccio;
import DSTeam3.maps.locations.MoriohGrand;
import DSTeam3.maps.locations.PassioneRestaurant;
import DSTeam3.maps.locations.PolnareffLand;
import DSTeam3.maps.locations.SanGiorgio;
import DSTeam3.maps.locations.SavageGarden;
import DSTeam3.maps.locations.TownHall;
import DSTeam3.maps.locations.TrattoriaTrussardi;
import DSTeam3.maps.locations.Vineyard;

public class AlternateMap extends Map{
    public AlternateMap(){
        this.mapName = "Alternate Map";
    }

    public AlternateMap(Location current){
        super(current);
        this.mapName = "Alternate Map";
    }

    @Override
    public void defineLocations(){
        // Define all of the locations present in map
        TownHall townHall = new TownHall(); /* Location 1 */
        MoriohGrand moriohGrand = new MoriohGrand(); /* Location 2 */
        TrattoriaTrussardi trattoriaTrussardi = new TrattoriaTrussardi(); /* Location 3 */
        GreenDolphin greenDolph = new GreenDolphin(); /* Location 4 */
        PassioneRestaurant passioneRestaurant = new PassioneRestaurant(); /* Location 5 */
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
        townHall.linkNearby(moriohGrand, 2); // location 1, 3 nearbys
        townHall.linkNearby(greenDolph, 3);
        townHall.linkNearby(passioneRestaurant, 7);
        moriohGrand.linkNearby(sanGiorgio, 3); // location 2, 4 nearbys
        moriohGrand.linkNearby(joestarMansion, 4);
        moriohGrand.linkNearby(greenDolph, 2);
        trattoriaTrussardi.linkNearby(joestarMansion, 5); // location 3, 3 nearbys
        trattoriaTrussardi.linkNearby(greenDolph, 4);
        trattoriaTrussardi.linkNearby(passioneRestaurant, 1);
        // location 4: Green Dolphin Street Prison has been fully linked
        passioneRestaurant.linkNearby(angeloRock, 6); // location 5, 5 nearbys
        passioneRestaurant.linkNearby(dioMansion, 2);
        passioneRestaurant.linkNearby(cafeDeux, 4);
        sanGiorgio.linkNearby(savageGarden, 6); // location 6, 2 nearbys
        jadeGarden.linkNearby(angeloRock, 1); // location 7, 2 nearbys
        jadeGarden.linkNearby(polnareffLand, 2);
        cafeDeux.linkNearby(vineyard, 4); // location 8, 3 nearbys
        cafeDeux.linkNearby(dioMansion, 1);
        // location 9: Joestar Mansion has been fully linked
        dioMansion.linkNearby(polnareffLand, 2); // location 10, 3 nearbys
        // location 11: Angelo Rock has been fully linked
        vineyard.linkNearby(savageGarden, 4); // location 12, 2 nearbys
        // location 13: Savage Garden has been fully linked
        polnareffLand.linkNearby(angeloRock, 2); // location 14, 3 nearbys

        /* Add all nodes to locations ArrayList to be stored */
        locations.add(townHall); // location 1
        locations.add(moriohGrand); // location 2
        locations.add(trattoriaTrussardi); // location 3
        locations.add(greenDolph); // location 4
        locations.add(passioneRestaurant); // location 5
        locations.add(sanGiorgio); // location 6
        locations.add(jadeGarden); // location 7
        locations.add(cafeDeux); // location 8
        locations.add(joestarMansion); // location 9
        locations.add(dioMansion); // location 10
        locations.add(angeloRock); // location 11
        locations.add(vineyard); // location 12
        locations.add(savageGarden); // location 13
        locations.add(polnareffLand); // location 14

        /* Setting Town Hall as beginning location */
        setCurrentLocation(townHall);
    }
}