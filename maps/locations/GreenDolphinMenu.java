package DSTeam3.maps.locations;

import DSTeam3.ui.base.*;

public class GreenDolphinMenu extends Menu {
    public GreenDolphinMenu(){
        this.setLocationName("Green Dolphin Street Prison");
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){        
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        
        Option viewResident = new Option("View resident information");
        viewResident.addSuboptions("View resident profile");
        viewResident.addSuboptions("Sort");
        viewResident.addSuboptions("Exit");
    
        Option ddddc = new Option("Dirty Deeds Done Dirt Cheap");

        Option backPrevious = new Option("Back to previous location");
        backPrevious.addSuboptions("Yes");
        backPrevious.addSuboptions("No");

        Option backTownHall = new Option("Back to Town Hall");

        Option[] options = {moveTo, viewResident, ddddc, backPrevious, backTownHall};
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
            case "Trattoria Trussardi":
                setMovingLocations(true);
                return "Trattoria Trussardi";
            case "Libeccio":
                setMovingLocations(true);
                return "Libeccio";
            case "Angelo Rock":
                setMovingLocations(true);
                return "Angelo Rock";
            case "DIO's Mansion":
                setMovingLocations(true);
                return "DIO's Mansion";
            case "Morioh Grand Hotel":
                setMovingLocations(true);
                return "Morioh Grand Hotel";
            case "Town Hall":
                setMovingLocations(true);
                return "Town Hall";
            case "Go forward to visited location":
                setMovingLocations(true);
                setWantMoveForward(true);
                break;
            case "Dirty Deeds Done Dirt Cheap":
                setInitialiseDDDDC(true);
                break;
            case "View resident information":
                setViewResidentInfo(true);
                break;
            case "Exit":
                setReturnToFrontPage(true);
                break;
            case "Sort":
                setSortResidentInfo(true);
                break;
            case "View resident profile":
                setViewResidentProfile(true);
                break;
        }
        return null;
    }
}
