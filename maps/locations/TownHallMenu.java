package DSTeam3.maps.locations;

import DSTeam3.ui.base.Menu;
import DSTeam3.ui.base.*;
import DSTeam3.maps.base.*;

public class TownHallMenu extends Menu {
    /* Instance variables */

    /* Constructors */
    public TownHallMenu(){}

    /* Getter and setter methods */

   /* Purpose: Sets the greeting to notify user regarding day info: dayInfo() */
    @Override
    public void setNewDayGreeting(String newDayGreeting){
        setGreeting(newDayGreeting);
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        moveTo.addSuboptions("Cafe Deux Magots");
        moveTo.addSuboptions("Jade Garden");
        moveTo.addSuboptions("Morioh Grand Hotel");
        
        Option advanceNextDay = new Option("Advance to Next Day");
        
        Option saveGame = new Option("Save Game");

        Option exit = new Option("Exit");

        Option[] options = {moveTo, advanceNextDay, saveGame, exit};
        addOptions(options);
    }

    @Override
    public void execute(String inputStr){
        switch(getSelectedTitle()){
            case "Move to nearby location":
                setGreeting("Select a location to move to: ");
                break;
            case "Cafe Deux Magots":
                // move to
            case "Jade Garden":
                break;
            case "Morioh Grand Hotel":
                break;
            case "Advance to Next Day":
                setAdvanceNextDay(true);
                break;
            case "Save Game":
                System.out.println("Not developed yet");
                break;
            case "Exit":
                setExitGame(true);
                setExitInterface(true);
                System.out.println("Exiting game...");
                break;
        }
    }
}
