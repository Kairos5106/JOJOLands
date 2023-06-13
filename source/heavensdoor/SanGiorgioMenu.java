package DSTeam3.maps.locations;

import DSTeam3.ui.base.Menu;

public class SanGiorgioMenu extends Menu {
    
     public SanGiorgioMenu (){
        this.setLocationName("San Giorgio");
    }

    /* Getter and setter methods */

   /* Purpose: Sets the greeting to notify user regarding day info: dayInfo() */
    @Override
    public void setNewDayGreeting(String newDayGreeting){
        setGreeting(newDayGreeting);
    }
    
     public void defineOptions() {
        Option moveTo = new Option("Move to");
        moveTo.addSuboption("Jade Garden");
        moveTo.addSuboption("Trattoria Trusardi");
        moveTo.addSuboption("Libeccio");

        Option viewResidentInfo = new Option("View Resident Information");

        Option backPreviousLocation = new Option("Back", "");

        Option backToTownHall = new Option("Back to Town Hall");

        Option[] options = { moveTo, viewResidentInfo, backPreviousLocation, backToTownHall };
        addOptions(options);
    }
     
     @Override
    public void execute(String inputStr) {
        switch (getSelectedTitle()) {
            case "Move to":
                switch (inputStr) {
                    case "Jade Garden":
                        // Handle moving to Jade Garden
                        break;
                    case "Trattoria Trusardi":
                        // Handle moving to Trattoria Trusardi
                        break;
                    case "Libeccio":
                        // Handle moving to Libeccio
                        break;
                }
                break;
            case "View Resident Information":
                // Handle viewing resident information
                break;
            case "Back":
                switch (getSelectedSubtitle()) {
                    case "":
                        // Handle going back to previous location
                        break;
                }
                break;
            case "Back to Town Hall":
                // Handle going back to Town Hall
                break;
        }
    }
    
}
