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

public class ParallelMap extends Map{
    public ParallelMap(){
        this.mapName = "Parallel Map";
    }

    public ParallelMap(Location current){
        super(current);
        this.mapName = "Parallel Map";
    }

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
        townHall.linkNearby(trattoriaTrussardi, 6); // location 1, 4 nearbys
        townHall.linkNearby(vineyard, 3);
        townHall.linkNearby(libeccio, 2);
        townHall.linkNearby(cafeDeux, 4);
        moriohGrand.linkNearby(joestarMansion, 4); // location 2, 2 nearbys
        moriohGrand.linkNearby(cafeDeux, 6);
        trattoriaTrussardi.linkNearby(joestarMansion, 5); // location 3, 4 nearbys
        trattoriaTrussardi.linkNearby(dioMansion, 4);
        trattoriaTrussardi.linkNearby(angeloRock, 3);
        greenDolph.linkNearby(angeloRock, 8); // location 4, 2 nearbys
        greenDolph.linkNearby(dioMansion, 6);
        libeccio.linkNearby(vineyard, 3); // location 5, 2 nearbys
        sanGiorgio.linkNearby(joestarMansion, 5); // location 6, 2 nearbys
        sanGiorgio.linkNearby(savageGarden, 6);
        jadeGarden.linkNearby(joestarMansion, 3); // location 7, 3 nearbys
        jadeGarden.linkNearby(cafeDeux, 3);
        jadeGarden.linkNearby(savageGarden, 4);
        cafeDeux.linkNearby(polnareffLand, 2); // location 8, 5 nearbys
        cafeDeux.linkNearby(savageGarden, 5);
        // location 9: Joestar Mansion has been fully linked
        dioMansion.linkNearby(angeloRock, 1); // location 10, 3 nearbys
        // location 11: Angelo Rock has been fully linked
        // location 12: Vineyard has been fully linked
        // location 13: Savage Garden has been fully linked
        // location 14: Polnareff Land has been fully linked

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

        /* Setting Town Hall as beginning location */
        setCurrentLocation(townHall);
    }
}
