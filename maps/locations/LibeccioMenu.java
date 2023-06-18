package DSTeam3.maps.locations;

import DSTeam3.ui.base.*;

public class LibeccioMenu extends Menu {
    public LibeccioMenu(){
        this.setLocationName("Libeccio");
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){        
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        
        Option viewWaitingList = new Option("View waiting list and order processing list");

        Option viewMenu = new Option("View menu");

        // Options for view sales information - start
        Option viewSales = new Option("View sales information");
        
        Option viewAggregated = new Option("View aggregated information");
        viewAggregated.addSuboptions("Minimum sales");
        viewAggregated.addSuboptions("Maximum sales");
        viewAggregated.addSuboptions("Top k highest sales");
        viewAggregated.addSuboptions("Total and average sales");

        viewSales.addSuboptions("View sales");
        viewSales.addSuboptions(viewAggregated);
        viewSales.addSuboptions("Exit");
        // Options for view sales information - end
        
        // Options for milagro man - start
        Option milagroMan = new Option("Milagro Man");
        milagroMan.addSuboptions("Modify food prices");
        milagroMan.addSuboptions(viewSales);
        milagroMan.addSuboptions("Exit Milagro Man");
        // Options for milagro man - end

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
            case "San Giorgio Maggiore":
                setMovingLocations(true);
                return "San Giorgio Maggiore";
            case "Joestar Mansion":
                setMovingLocations(true);
                return "Joestar Mansion";
            case "Vineyard":
                setMovingLocations(true);
                return "Vineyard";
            case "DIO's Mansion":
                setMovingLocations(true);
                return "DIO's Mansion";
            case "Green Dolphin Street Prison":
                setMovingLocations(true);
                return "Green Dolphin Street Prison";
            case "Town Hall":
                setMovingLocations(true);
                return "Town Hall";
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
            case "View sales information":
                setViewSalesInfo(true);
                break;
            case "View sales":
                setViewSales(true);
                break;
            case "View aggregated information":
                setViewAggregated(true);
                break;
            case "Minimum sales":
                setViewMinSales(true);
                break;
            case "Maximum sales":
                setViewMaxSales(true);
                break;
            case "Top k highest sales":
                setViewTopK(true);
                break;
            case "Total and average sales":
                setViewTotalAvgSales(true);
                break;
            case "Exit":
                if(milagroManIsActive()){
                    setReturnToMilagroMan(true);
                }
                else{
                    setReturnToFrontPage(true);
                }
                setViewSalesInfo(false);
                break;
            case "Milagro Man":
                setMilagroMan(true);
                break;
            case "Modify food prices":
                setModifyFoodPrices(true);
                break;
            case "Exit Milagro Man":
                setMilagroMan(false);
                setReturnToFrontPage(true);
                break;
        }
        return null;
    }
}
