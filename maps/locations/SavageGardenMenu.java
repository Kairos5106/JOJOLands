package DSTeam3.maps.locations;

import DSTeam3.ui.base.*;

public class SavageGardenMenu extends Menu {
    public SavageGardenMenu(){
        this.setLocationName("Savage Garden");
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){        
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        
        Option viewWaitingList = new Option("View waiting list and order processing list");

        Option viewMenu = new Option("View menu");

        Option viewSales = new Option("View sales information");
        
        Option milagroMan = new Option("Milagro Man");

        Option backPrevious = new Option("Back to previous location");
        backPrevious.addSuboptions("Yes");
        backPrevious.addSuboptions("No");

        Option backTownHall = new Option("Back to Town Hall");

        Option[] options = {moveTo, viewWaitingList, viewMenu, viewSales, milagroMan, backPrevious, backTownHall};
        setOptions(options);
    }

    @Override
    public String execute(String inputStr){
        switch(getSelectedTitle()){
            case "Move to nearby location":
                setGreeting("Select a location to move to: ");
                setOpenMoveLocationsMenu(true);
                break;
            case "Back to Town Hall":
                setMovingLocations(true);
                setMoveTownHall(true);
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
            case "Cafe Deux Magots":
                setMovingLocations(true);
                return "Cafe Deux Magots";
            case "Polnareff Land":
                setMovingLocations(true);
                return "Polnareff Land";
            case "Joestar Mansion":
                setMovingLocations(true);
                return "Joestar Mansion";
            case "Vineyard":
                setMovingLocations(true);
                return "Vineyard";
            case "Jade Garden":
                setMovingLocations(true);
                return "Jade Garden";
            case "San Giorgio Maggiore":
                setMovingLocations(true);
                return "San Giorgio Maggiore";
            case "Go forward to visited location":
                setMovingLocations(true);
                setWantMoveForward(true);
                break;
            case "View menu":
                setViewFoodMenu(true);
                break;
            case "View waiting list and order processing list":
                setViewPearlJamList(true);
                break;
        }
        return null;
    }
}
