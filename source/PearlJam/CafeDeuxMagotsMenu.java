package source.PearlJam;

import ui.base.*;

public class CafeDeuxMagotsMenu extends Menu {
    public CafeDeuxMagotsMenu(){
        this.setLocationName("Cafe Deux Magots");
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){        
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        moveTo.addSuboptions("Jade Garden");
        moveTo.addSuboptions("Savage Garden");
        moveTo.addSuboptions("Polnareff Land");
        moveTo.addSuboptions("Town Hall");

        Option viewWaitingList = new Option("View Waiting List and Order Processing List");

        Option viewMenu = new Option("View Menu");

        Option viewSales = new Option("View Sales Information");
        
        Option milagroMan = new Option("Milagro Man");

        Option backPrevious = new Option("Back to previous location");
        backPrevious.addSuboptions("Yes");
        backPrevious.addSuboptions("No");

        Option backTownHall = new Option("Back to Town Hall");

        Option[] options = {moveTo, backPrevious, backTownHall};
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
            case "Jade Garden":
                setMovingLocations(true);
                return "Jade Garden";
            case "Savage Garden":
                setMovingLocations(true);
                return "Savage Garden";
            case "Polnareff Land":
                setMovingLocations(true);
                return "Polnareff Land";
            case "Go forward to visited location":
                setMovingLocations(true);
                setWantMoveForward(true);
                break;
        }
        return "";
    }
}
