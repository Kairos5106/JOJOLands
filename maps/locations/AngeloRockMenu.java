package DSTeam3.maps.locations;

import DSTeam3.ui.base.*;

public class AngeloRockMenu extends Menu {
    public AngeloRockMenu(){
        this.setLocationName("Angelo Rock");
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
            case "DIO's Mansion":
                setMovingLocations(true);
                return "DIO's Mansion";
            case "Green Dolphin Street Prison":
                setMovingLocations(true);
                return "Green Dolphin Street Prison";
            case "Trattoria Trussardi":
                setMovingLocations(true);
                return "Trattoria Trussardi";
            case "Jade Garden":
                setMovingLocations(true);
                return "Jade Garden";
            case "Polnareff Land":
                setMovingLocations(true);
                return "Polnareff Land";
            case "Passione Restaurant":
                setMovingLocations(true);
                return "Passione Restaurant";
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
