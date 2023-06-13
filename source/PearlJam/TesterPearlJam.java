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
        jadeGardenMenu.addCustomerToWaitingList(new Customer("Jonathan Joestar", 20, "Male"));
        jadeGardenMenu.addCustomerToWaitingList(new Customer("Joseph Joestar", 18, "Male"));
        jadeGardenMenu.addCustomerToWaitingList(new Customer("Jotaro Kujo", 17, "Male"));
        jadeGardenMenu.addCustomerToWaitingList(new Customer("Josuke Higashikata", 16, "Male"));
        jadeGardenMenu.addCustomerToWaitingList(new Customer("Giorno Giovanna", 15, "Male"));
        jadeGardenMenu.addCustomerToWaitingList(new Customer("Jolyne Cujoh", 19, "Female"));

        for (int i=0 ; i<10 ; i++) {
            JadeGardenMenu.displayJadeGardenMenu();
            String userInput = scanner.nextLine();
            String result = jadeGardenMenu.execute(userInput);
            scanner.nextLine();
            if (!result.isEmpty()) {
                System.out.println("Moving to: " + result);
            }
        }

    }
}