package DSTeam3.source.PearlJam;

import java.util.Scanner;

import DSTeam3.ui.GameInterface;
import DSTeam3.ui.StartInterface;
import DSTeam3.ui.StartMenu;

/* This class is used to initialize Jojolands */
public class TesterPearlJam {
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


        // Run pearl jam jade garden
        JadeGardenMenu jadeGardenMenu = new JadeGardenMenu();
        Scanner scanner = new Scanner(System.in);

        String userInput;
        do {
            JadeGardenMenu.displayJadeGardenMenu();
            userInput = scanner.nextLine();
            JadeGardenMenu.processUserInput();
        } while (!userInput.equals("7"));
    }
}