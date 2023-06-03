import ui.GameInterface;
import ui.StartInterface;
import ui.StartMenu;
import maps.base.Location;
import maps.locations.*;
import Pearl_Jam.RestaurantsMenu;

/* This class is used to initialize Jojolands */
public class Main {

    public static void main(String[] args) {
        /* Section 1: Code for initializing JOJOLands */
        /* Initializing required variables before initiateing menu */
        StartInterface startUI = new StartInterface(new StartMenu());

        /* Displaying start menu and prompt user for input */
        startUI.initiate();
        if(startUI.getExitGame()){return;}

        /* Section 2: Load selected map and user interface */
        GameInterface gameUI = new GameInterface(startUI.getMapSelected(), new TownHallMenu());
    
        /* Section 3: Start game */
        gameUI.initiate();

        RestaurantsMenu restaurantsMenu = new RestaurantsMenu();
        restaurantsMenu.run();
    }
}
