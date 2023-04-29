package DSTeam3.maps;

/* Name: Default Map
 * Number of locations: 14 locations
 * Range of nearby locations: 2 to 5 nearby locations
 */
public class DefaultMap extends Map{
    /* Instance variables */
    private MoriohGrand moriohGrand = new MoriohGrand(); /* Location 2 */
    private TrattoriaTrussardi trattoriaTrussardi = new TrattoriaTrussardi(); /* Location 3 */
    private GreenDolphin greenDolph = new GreenDolphin(); /* Location 4 */
    private Libeccio libeccio = new Libeccio(); /* Location 5 */
    private SanGiorgio sanGiorgio = new SanGiorgio(); /* Location 6 */
    private JadeGarden jadeGarden = new JadeGarden(); /* Location 7 */
    private CafeDeux cafeDeux = new CafeDeux(); /* Location 8 */
    private JoestarMansion joestarMansion = new JoestarMansion(); /* Location 9 */
    private DioMansion dioMansion = new DioMansion(); /* Location 10 */
    private AngeloRock angeloRock = new AngeloRock(); /* Location 11 */
    private Vineyard vineyard = new Vineyard(); /* Location 12 */
    private SavageGarden savageGarden = new SavageGarden(); /* Location 13 */
    private PolnareffLand polnareffLand = new PolnareffLand(); /* Location 14 */

    /* Constructors */
    public DefaultMap(){
        super();
        this.mapName = "Default Map";
    }
    public DefaultMap(Location current){
        super(current);
        this.mapName = "Default Map";
    }

    /* Class methods */
    /* Purpose: Links all of the location to their respective nearbys in the map */
    public void linkAll(){
        /* Linking the nodes to their respective nearby locations */
        townHall.addNearby(moriohGrand, 5); // location 1, 3 nearbys
        townHall.addNearby(jadeGarden, 5);
        townHall.addNearby(cafeDeux, 4);
        moriohGrand.addNearby(jadeGarden, 3); // location 2, 2 nearbys
        moriohGrand.addNearby(trattoriaTrussardi, 6);
        trattoriaTrussardi.addNearby(sanGiorgio, 3); // location 3, 3 nearbys
        trattoriaTrussardi.addNearby(greenDolph, 6);
        greenDolph.addNearby(libeccio, 3); // location 4, 3 nearbys
        greenDolph.addNearby(angeloRock, 2);
        libeccio.addNearby(dioMansion, 2); // location 5, 5 nearbys
        libeccio.addNearby(vineyard, 6);
        libeccio.addNearby(joestarMansion, 6);
        libeccio.addNearby(sanGiorgio, 4);
        sanGiorgio.addNearby(jadeGarden, 2); // location 6, 3 nearbys
        jadeGarden.addNearby(joestarMansion, 2); // location 7, 5 nearbys 
        jadeGarden.addNearby(cafeDeux, 3); 
        cafeDeux.addNearby(polnareffLand, 4); // location 8, 4 nearbys
        cafeDeux.addNearby(savageGarden, 4);
        joestarMansion.addNearby(savageGarden, 4); // location 9, 4 nearbys
        joestarMansion.addNearby(vineyard, 3);
        dioMansion.addNearby(vineyard, 3); // location 10, 3 nearbys
        dioMansion.addNearby(angeloRock, 3);
        // location 11 has been fully linked
        vineyard.addNearby(savageGarden, 8); // location 12, 4 nearbys
        savageGarden.addNearby(polnareffLand, 6); // location 13, 4 nearbys
        // location 14 has been fully linked

        /* Add all nodes to locations ArrayList to be stored */
        locations.add(this.townHall); // location 1
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
    }
}