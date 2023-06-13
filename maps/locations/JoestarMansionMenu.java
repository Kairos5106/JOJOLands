package DSTeam3.maps.locations;

import DSTeam3.ui.base.*;

public class JoestarMansionMenu extends Menu {
    public JoestarMansionMenu(){
        this.setLocationName("Joestar Mansion");
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

        Option backPrevious = new Option("Back to previous location");
        backPrevious.addSuboptions("Yes");
        backPrevious.addSuboptions("No");

        Option backTownHall = new Option("Back to Town Hall");

        Option[] options = {moveTo, viewResident, backPrevious, backTownHall};
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
            case "Jade Garden":
                setMovingLocations(true);
                return "Jade Garden";
            case "Savage Garden":
                setMovingLocations(true);
                return "Savage Garden";
            case "Libeccio":
                setMovingLocations(true);
                return "Libeccio";
            case "Vineyard":
                setMovingLocations(true);
                return "Vineyard";
            case "San Giorgio Maggiore":
                setMovingLocations(true);
                return "San Giorgio Maggiore";
            case "Morioh Grand Hotel":
                setMovingLocations(true);
                return "Morioh Grand Hotel";
            case "Trattoria Trussardi":
                setMovingLocations(true);
                return "Trattoria Trussardi";
            case "Go forward to visited location":
                setMovingLocations(true);
                setWantMoveForward(true);
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
        }
        return null;
    }
}
