package source.Pearl_Jam;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ui.base.*;

public class JadeGardenMenu extends Menu {

    private static JadeGarden jadeGarden;
    private static Scanner scanner;

    public JadeGardenMenu(){
        this.setLocationName("Jade Garden");
    }

    public static void main(String[] args) {
        jadeGarden = new JadeGarden();
        scanner = new Scanner(System.in);

        displayMenu();
        processUserInput();
    }

    public static void displayMenu() {
        System.out.println("Current Location: " + jadeGarden.getNameRestaurant());
        System.out.println("[1] Move to:");
        System.out.println("[A] Cafe Deux Magots   [B] Joestar Mansion");
        System.out.println("[C] Morioh Grand Hotel [D] San Giorgio Maggiore");
        System.out.println("[E] Town Hall");
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        System.out.println("[6] Back (Town Hall)");
        System.out.println("[7] Back to Town Hall");
        System.out.print("Select: ");
    }

    public static void processUserInput() {
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                System.out.print("Move to: ");
                String location = scanner.nextLine();
                // Process the location movement here
                System.out.println("Moving to " + location);
                break;
            case "A":
                System.out.println("Moving to Cafe Deux Magots");
                break;
            case "B":
                System.out.println("Moving to Joestar Mansion");
                break;
            case "C":
                System.out.println("Moving to Morioh Grand Hotel");
                break;
            case "D":
                System.out.println("Moving to San Giorgio Maggiore");
                break;
            case "E":
                System.out.println("Moving to Town Hall");
                break;
            case "2":
                displayWaitingListAndOrderProcessingList();
                break;
            case "3":
                displayMenu(jadeGarden.getMenu());
                break;
            case "4":
                // View sales information
                break;
            case "5":
                // Perform Milagro Man action
                break;
            case "6":
                System.out.println("Going back to the previous location");
                break;
            case "7":
                System.out.println("Returning to Town Hall");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        // Continue the running process
        processUserInput();
    }

    public static void displayWaitingListAndOrderProcessingList() {
        jadeGarden.displayWaitingListAndOrderProcessingList();
    }

    public static void displayMenu(List<String> menu) {
        System.out.println("Menu");
        System.out.println("+-------------------------------------+");
        for (String item : menu) {
            System.out.println("| " + item + " |");
        }
        System.out.println("+-------------------------------------+");
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){        
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        moveTo.addSuboptions("Cafe Deux Magots");
        moveTo.addSuboptions("Joestar Mansion");
        moveTo.addSuboptions("Morioh Grand Hotel");
        moveTo.addSuboptions("San Giorgio Maggiore");
        moveTo.addSuboptions("Town Hall");

        Option viewWaitingList = new Option("View Waiting List and Order Processing List");

        Option viewMenu = new Option("View Menu");

        Option viewSales = new Option("View Sales");
        
        Option milagroMan = new Option("Milagro Man");

        Option backPrevious = new Option("Back to previous location");
        backPrevious.addSuboptions("Yes");
        backPrevious.addSuboptions("No");

        Option backTownHall = new Option("Back to Town Hall");

        Option[] options = {moveTo, viewWaitingList, viewMenu, viewSales, milagroMan, backPrevious, backTownHall};
        setOptions(options);
    }

    /* Purpose: Processes user input and takes the appropriate action depending on which option was selected */
    @Override
    public String execute(String inputStr){
        switch(getSelectedTitle()){
            case "Move to nearby location":
                setGreeting("Select a location to move to: ");
                setOpenMoveLocationsMenu(true);
                break;
            case "Back to Town Hall":
                setMovingLocations(true);
                return "Town Hall";
            case "Back to previous location":
                setReturnPreviousLocation(true);
                break;
            case "Yes":
                setMovingLocations(true);
                break;
            case "No":
                setReturnToFrontPage(true);
                break;
            case "Town Hall":
                setMovingLocations(true);
                return "Town Hall";
            case "Morioh Grand Hotel":
                setMovingLocations(true);
                return "Morioh Grand Hotel";
            case "San Giorgio Maggiore":
                setMovingLocations(true);
                return "San Giorgio Maggiore";
            case "Cafe Deux Magots":
                setMovingLocations(true);
                return "Cafe Deux Magots";
            case "Joestar Mansion":
                setMovingLocations(true);
                return "Joestar Mansion";
            case "Go forward to visited location":
                setMovingLocations(true);
                setWantMoveForward(true);
                break;
            case "View Waiting List and Order Processing List":
                displayWaitingListAndOrderProcessingList();
                break;
            case "View Menu":
                displayMenu();
                break;
            case "View Sales Information":
                displaySalesInformation();
                break;
            case "Milagro Man":
                performMilagroManAction();
                break;
        }
        return "";
    }

    
}
