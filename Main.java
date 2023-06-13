package DSTeam3;

import DSTeam3.ui.GameInterface;
import DSTeam3.ui.StartInterface;
import DSTeam3.ui.StartMenu;

/* This class is used to initialize Jojolands */
public class Main{
    public static void main(String[] args) {
        /* Section 1: Code for initializing JOJOLands */
        /* Initializing required variables before initiating menu */
        StartInterface startUI = new StartInterface(new StartMenu());

        /* Displaying start menu and prompt user for input */
        startUI.initiate();
        if(startUI.getExitGame()){
            return;
        }

        /* Section 2: Load selected map and user interface */
        GameInterface gameUI = new GameInterface(startUI.getMapSelected());
        
        /* Section 3: Start game */
        gameUI.initiate();
    }
}