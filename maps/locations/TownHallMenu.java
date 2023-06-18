package DSTeam3.maps.locations;

import DSTeam3.ui.base.*;

public class TownHallMenu extends Menu {
    /* Instance variables */

    /* Constructors */
    public TownHallMenu(){
        this.setLocationName("Town Hall");
    }

    /* Getter and setter methods */

   /* Purpose: Sets the greeting to notify user regarding day info: dayInfo() */
    @Override
    public void setNewDayGreeting(String newDayGreeting){
        setGreeting(newDayGreeting);
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){
        setAdvanceNextDay(false);
        
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        
        Option advanceNextDay = new Option("Advance to next day");
        
        Option saveGame = new Option("Save game");

        Option exit = new Option("Exit");

        Option[] options = {moveTo, advanceNextDay, saveGame, exit};
        setOptions(options);
    }

    @Override
    public String execute(String inputStr){
        switch(getSelectedTitle()){
            case "Move to nearby location":
                setGreeting("Select a location to move to: ");
                setOpenMoveLocationsMenu(true);
                break;
            case "Cafe Deux Magots": // move location
                setMovingLocations(true);
                return "Cafe Deux Magots";
            case "Jade Garden": // // move location
                setMovingLocations(true);
                return "Jade Garden";
            case "Morioh Grand Hotel": // move location
                setMovingLocations(true);
                return "Morioh Grand Hotel";
            case "Trattoria Trussardi":
                setMovingLocations(true);
                return "Trattoria Trussardi";
            case "Vineyard":
                setMovingLocations(true);
                return "Vineyard";
            case "Libeccio":
                setMovingLocations(true);
                return "Libeccio";
            case "Green Dolphin Street Prison":
                setMovingLocations(true);
                return "Green Dolphin Street Prison";
            case "Passione Restaurant":
                setMovingLocations(true);
                return "Passione Restaurant";
            case "Advance to next day":
                setAdvanceNextDay(true);
                break;
            case "Save game":
                setCreateSaveFile(true);
                break;
            case "Exit":
                setExitGame(true);
                setExitInterface(true);
                System.out.println("Exiting game...");
                break;
            case "Go forward to visited location":
                setMovingLocations(true);
                setWantMoveForward(true);
                break;
            case "Yes":
                setMovingLocations(true);
                break;
            case "No":
                setReturnToFrontPage(true);
                break;
        }
        return null;
    }
}
