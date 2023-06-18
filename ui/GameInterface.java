package DSTeam3.ui;

import DSTeam3.maps.AlternateMap;
import DSTeam3.maps.DefaultMap;
import DSTeam3.maps.ParallelMap;
import DSTeam3.maps.base.*;
import DSTeam3.ui.base.Menu;
import DSTeam3.ui.base.Option;
import DSTeam3.ui.base.UserInterface;
import java.util.ArrayList;
import DSTeam3.maps.locations.AngeloRockMenu;
import DSTeam3.maps.locations.CafeDeuxMenu;
import DSTeam3.maps.locations.DioMansionMenu;
import DSTeam3.maps.locations.GreenDolphinMenu;
import DSTeam3.maps.locations.JadeGardenMenu;
import DSTeam3.maps.locations.JoestarMansionMenu;
import DSTeam3.maps.locations.LibeccioMenu;
import DSTeam3.maps.locations.MoriohGrandMenu;
import DSTeam3.maps.locations.PolnareffLandMenu;
import DSTeam3.maps.locations.SanGiorgioMenu;
import DSTeam3.maps.locations.SavageGardenMenu;
import DSTeam3.maps.locations.TownHallMenu;
import DSTeam3.maps.locations.TrattoriaTrussardiMenu;
import DSTeam3.maps.locations.VineyardMenu;
import DSTeam3.source.DDDDC.PathFinder;
import DSTeam3.source.GoldenSpirit;
import DSTeam3.source.HeavensDoor;
import DSTeam3.source.Joestars.*;
import DSTeam3.source.MilagroMan.MilagroMan;
import DSTeam3.source.MoodyBlues.MoodyBlues;
import DSTeam3.source.PearlJam.base.PearlJam;
import DSTeam3.source.SuperFly.*;
import DSTeam3.source.TheWorld.GameState;
import DSTeam3.source.TheWorld.TheWorld;

public class GameInterface extends UserInterface{
    /* Instance variables */
    private Clock time = new Clock(); // keeps track of the time in-game
    private boolean newDay = true; // to help with notifying the player with current day count and day name
    Map map;
    ArrayList<Menu> listOfLocationMenus = new ArrayList<>(); // holds all of the menu interfaces of each location as well as the special functions

    PathFinder pathFinder = new PathFinder();
    HeavensDoor heavensDoor = new HeavensDoor();
    TheJoestars joestars = new TheJoestars();
    GoldenSpirit goldenSpirit = new GoldenSpirit();
    MoodyBlues moodyBlues = new MoodyBlues();
    MilagroMan milagro = new MilagroMan();
    TheWorld world = new TheWorld();
    GameState gameState = new GameState();

    boolean loadingSaveFile = false;
    static boolean alreadyGeneratedDefaultMilagro = false;

    /* Constructors */
    public GameInterface(){}

    public GameInterface(GameState gameStateToLoad){
        this.gameState = gameStateToLoad;
        loadingSaveFile = true;
    }

    public GameInterface(Map map){
        this.map = map;
    }

    /* ****************** Method A: Getter and setter methods ****************** */

    public void setDayCount(int dayCount){
        time.setDayCount(dayCount);
    }

    public String getDayInfo(){
        return time.dayInfo();
    }

    public void setMap(String mapName){
        if(mapName.equalsIgnoreCase("Default Map")){
            this.map = new DefaultMap();
        }
        else if(mapName.equalsIgnoreCase("Alternate Map")){
            this.map = new AlternateMap();
        }
        else{
            this.map = new ParallelMap();
        }
    }

    public Map getMap(){
        return this.map;
    }

    public Location getCurrentLocation(){
        return getMap().getCurrentLocation();
    }

    public String[] getNearbyLocationNames(){
        return getCurrentLocation().getNearbyLocationNames();
    }

    public Menu getCurrentMenu(){
        return this.map.getCurrentMenu();
    }

    public void presetListOfMenus(){
        listOfLocationMenus.add(new TownHallMenu()); // 0
        listOfLocationMenus.add(new MoriohGrandMenu()); // 1
        listOfLocationMenus.add(new TrattoriaTrussardiMenu());// 2
        listOfLocationMenus.add(new GreenDolphinMenu()); // 3
        listOfLocationMenus.add(new LibeccioMenu());// 4
        listOfLocationMenus.add(new SanGiorgioMenu()); // 5
        listOfLocationMenus.add(new JadeGardenMenu()); // 6
        listOfLocationMenus.add(new CafeDeuxMenu()); // 7
        listOfLocationMenus.add(new JoestarMansionMenu()); // 8
        listOfLocationMenus.add(new DioMansionMenu());// 9
        listOfLocationMenus.add(new AngeloRockMenu());// 10
        listOfLocationMenus.add(new VineyardMenu());// 11
        listOfLocationMenus.add(new SavageGardenMenu());// 12
        listOfLocationMenus.add(new PolnareffLandMenu());// 13
    }

    public void setNewDay(boolean newDay){
        this.newDay = newDay;
    }

    public boolean isNewDay(){
        return this.newDay;    
    }

    public boolean isAdvancingNext(){
        return this.currentMenu.getAdvanceNextDay();
    }

    public boolean openMoveLocationsMenu(){
        return currentMenu.getOpenMoveLocationsMenu();
    }
    
    public boolean movingLocations(){
        return currentMenu.movingLocations();
    }

    public boolean returnPreviousLocation(){
        return currentMenu.returnPreviousLocation();
    }

    public boolean returnToFrontPage(){
        return currentMenu.returnToFrontPage();
    }

    public boolean moveTownHall(){
        return currentMenu.moveTownHall();
    }

    public boolean hasForwardLocation(){
        return this.map.hasForwardLocation();
    }
    
    public boolean wantMoveForward(){
        return currentMenu.wantMoveForward();
    }

    public boolean initialiseDDDDC(){
        return currentMenu.initialiseDDDDC();
    }

    public boolean hasForwardAdded(){
        return currentMenu.hasForwardAdded(); 
    }

    public boolean viewResidentInfo(){
        return currentMenu.viewResidentInfo();
    }

    public boolean sortResidentInfo(){
        return currentMenu.sortResidentInfo();
    }

    public boolean viewResidentProfile(){
        return currentMenu.viewResidentProfile();
    }

    public boolean initialiseGoldenSpirit(){
        return currentMenu.initialiseGoldenSpirit();
    }

    public boolean viewFoodMenu(){
        return currentMenu.viewFoodMenu();
    }

    public boolean viewPearlJamList(){
        return currentMenu.viewPearlJamList();
    }

    public PearlJam getCurrentRestaurant(){
        return getCurrentLocation().getRestaurant();
    }

    public boolean viewSalesInfo(){
        return currentMenu.viewSalesInfo();
    }

    public boolean viewSales(){
        return currentMenu.viewSales();
    }

    public boolean viewAggregated(){
        return currentMenu.viewAggregated();
    }

    public boolean viewMinSales(){
        return currentMenu.viewMinSales();
    }

    public boolean viewMaxSales(){
        return currentMenu.viewMaxSales();
    }

    public boolean viewTopK(){
        return currentMenu.viewTopK();
    }

    public boolean viewTotalAvgSales(){
        return currentMenu.viewTotalAvgSales();
    }

    public boolean milagroManIsActive(){
        return currentMenu.milagroManIsActive();
    }

    public boolean modifyFoodPrices(){
        return currentMenu.modifyFoodPrices();
    }

    public boolean returnToMilagroMan(){
        return currentMenu.returnToMilagroMan();
    }

    public boolean viewRedHotChilliPepper(){
        return currentMenu.viewRedHotChilliPepper();
    }

    public boolean viewTheHand(){
        return currentMenu.viewTheHand();
    }
    
    public boolean createSaveFile(){
        return currentMenu.createSaveFile();
    }

    /* ****************** Methods B: Display methods ****************** */

    /* ****************** Methods C: Processing methods (everything aside from A and B) ****************** */

    public void endDay(){
        time.endDay();
        setNewDay(true);
    }

    public String execute(){
        return "";
    }

    @Override
    public void initiate(){
        if(loadingSaveFile){
            setMap(gameState.getMapName());
            setDayCount(gameState.getDayCount());
            time.setDayOfWeek(gameState.getDayCount());
            loadingSaveFile = false;
            System.out.println("Loading into " + gameState.getMapName() + " on Day " + gameState.getDayCount() + " ...");
        }
        map.defineLocations();
        presetListOfMenus();
        setCurrentMenu(getCurrentMenu());
        currentMenu.defineOptions();
        currentMenu.setDefaultOption();
        joestars.assignFoodToResidents();
        gameState.setMapName(getMap().getMapName());
        String input = "";
        divider(70);
        while(!getExitInterface()){
            String executeOutput = "";
            if(isNewDay()){
                currentMenu.setNewDayGreeting(getDayInfo());
                setNewDay(false);
            }
            if(openMoveLocationsMenu()){
                String[] nearbyLocationList = getNearbyLocationNames();
                currentMenu.getCurrentOption().addSuboptions(nearbyLocationList);
                currentMenu.setOpenMoveLocationsMenu(false);
            }
            if(initialiseDDDDC()){
                PathFinder.PathFinderMethod(getMap().getMapName());
                currentMenu.setInitialiseDDDDC(false);
                currentMenu.setReturnToFrontPage(true);
            }
            if(initialiseGoldenSpirit()){
                goldenSpirit.GoldenSpirit();
                currentMenu.setInitialiseGoldenSpirit(false);
                currentMenu.setReturnToFrontPage(true);
            }
            if(viewFoodMenu()){
                getCurrentLocation().displayFoodMenu();
                currentMenu.setReturnToFrontPage(true);
                currentMenu.setViewFoodMenu(false);
                divider(70);
            }
            if(viewPearlJamList()){
                getCurrentRestaurant().generateWaitingList(time.getDayCount());
                getCurrentRestaurant().displayWaitingList();
                getCurrentRestaurant().generateOrderProcessingList();
                getCurrentRestaurant().displayOrderProcessingList();
                divider(70);
                currentMenu.setViewPearlJamList(false);
                currentMenu.setReturnToFrontPage(true);
            }
            if(createSaveFile()){
                gameState.setCurrentDateTimeToNow();
                gameState.setDayCount(time.getDayCount());
                world.saveGame(gameState);
                currentMenu.setCreateSaveFile(false);
                currentMenu.setReturnToFrontPage(true);
                divider(70);
            }
            if(returnToFrontPage()){
                if(viewResidentInfo()){
                    currentMenu.setViewResidentInfo(false);
                    currentMenu.setSortResidentInfo(false);
                }
                if(hasForwardLocation()){
                    currentMenu.setHasForwardAdded(false);
                }
                setCurrentMenu(getCurrentLocation().getMenu());
                currentMenu.setCurrentOption(-1);
                currentMenu.defineOptions();
                currentMenu.setDefaultOption();
                currentMenu.setReturnPreviousLocation(false);
                currentMenu.setReturnToFrontPage(false);
                currentMenu.setGreeting(null);
            }
            if(returnPreviousLocation() && !movingLocations()){
                currentMenu.setGreeting("Are you sure you want to return to " + map.getPreviousLocationName() + "?");
            }
            if(hasForwardLocation() && !hasForwardAdded()){
                currentMenu.getCurrentOption().addSuboptions(new Option("Go forward to visited location"));
                currentMenu.setHasForwardAdded(true);
            }
            if(sortResidentInfo()){
                heavensDoor.promptToSort();
                divider(70);
            }
            if(viewResidentInfo()){
                heavensDoor.setLocation(currentMenu.getLocationName());
                if(viewResidentProfile()){
                    heavensDoor.promptResidentProfile();
                    divider(70);
                    heavensDoor.displayResidentProfile();
                    joestars.displayOrderHistory(heavensDoor.getProfileName());
                    currentMenu.setViewResidentProfile(false);
                    divider(70);
                }
                heavensDoor.displayResidents();
                if(sortResidentInfo()){
                    currentMenu.setSortResidentInfo(false);
                }
            }
            if(viewSalesInfo()){
                moodyBlues.setName(getCurrentLocation().getName());
                // System.out.println("milagromanactive at salesinfo: " + milagroManIsActive()); // debug
                moodyBlues.readFile(milagroManIsActive());
                if(milagroManIsActive()){
                    currentMenu.setGreeting("Sales Information (Milagro Man)");
                }
                else{
                    currentMenu.setGreeting("Sales Information");
                }
                if(viewSales()){   
                    int day = Integer.parseInt(prompt("Enter day: "));
                    divider(70);
                    moodyBlues.displaySales(day);
                    currentMenu.setViewSales(false);
                    divider(70);
                }
                if(viewAggregated()){
                    currentMenu.setGreeting("Select which aggregated information to view: ");
                    currentMenu.resetSelectedOptions();
                }
                if(viewMinSales()){
                    System.out.printf("Minimum Sales: $%.2f\n", moodyBlues.getMinimumSales());
                }
                if(viewMaxSales()){
                    System.out.printf("Maximum Sales: $%.2f\n", moodyBlues.getMaximumSales());
                }
                if(viewTopK()){
                    int k = Integer.parseInt(prompt("Enter value of k: "));
                    divider(70);
                    moodyBlues.displayTopHighestSales(k);
                }
                if(viewTotalAvgSales()){
                    int startDay = Integer.parseInt(prompt("Enter start day: "));
                    int endDay = Integer.parseInt(prompt("Enter end day: "));
                    divider(70);
                    moodyBlues.displayTotalAndAverageSales(startDay, endDay);
                }
            }
            if(viewMinSales() || viewMaxSales() || viewTopK() || viewTotalAvgSales()){
                currentMenu.setViewSalesMenu();
                currentMenu.resetSelectedOptions();
                currentMenu.setGreeting(null);
                currentMenu.setViewMinSales(false);
                currentMenu.setViewMaxSales(false);
                currentMenu.setViewTopK(false);
                currentMenu.setViewTotalAvgSales(false);
                currentMenu.setViewAggregated(false);
                divider(70);
            }
            if(milagroManIsActive()){
                milagro.setRestaurantName(getCurrentLocation().getName());
                milagro.readFile();
                if(!alreadyGeneratedDefaultMilagro){
                    milagro.generateSaleEntries();
                    alreadyGeneratedDefaultMilagro = true;
                    // System.out.println("Generating default entries for modified prices"); // debug
                }
                if(!viewSalesInfo()){
                    currentMenu.setGreeting("Milagro Man Mode");
                }
                if(modifyFoodPrices()){
                    milagro.promptModifyFoodPrice();
                    milagro.generateSaleEntries();
                    // System.out.println("Generating modified entries for modified prices"); // debug
                }
            }
            else{
                alreadyGeneratedDefaultMilagro = false;
                milagro.resetVar();
            }
            if(modifyFoodPrices() || returnToMilagroMan()){
                if(!returnToMilagroMan()){
                    divider(70);
                }
                currentMenu.setMilagroManMenu();
                currentMenu.resetSelectedOptions();
                currentMenu.setGreeting(null);
                currentMenu.setModifyFoodPrices(false);
                currentMenu.setReturnToMilagroMan(false);
                currentMenu.setGreeting("Milagro Man Mode");
            }
            if(viewTheHand()){
                TheHand theHand1 = new TheHand(getMap());
                int totalRemovedConnections1 = theHand1.findTotalRemovedConnections();
                System.out.println("\nTotal Removed Connections: " + totalRemovedConnections1);
                divider(70);
                currentMenu.setViewTheHand(false);
            }
            if(viewRedHotChilliPepper()){
                RedHotChiliPepper redHotChiliPepper1 = new RedHotChiliPepper(getMap());
                int minimumLength1 = redHotChiliPepper1.findMinimumLength();
                divider(70);
                currentMenu.setViewRedHotChilliPepper(false);
            }

            // RUN DISPLAY 
            currentMenu.runDisplay();
            input = prompt("Select: ", currentMenu.getMaxOptionRange());
            currentMenu.setSelected(Integer.parseInt(input)-1, true);
            divider(70);
            executeOutput = currentMenu.execute(input);
            if(!movingLocations()){
                currentMenu.setCurrentOption(Integer.parseInt(input)-1);
            }

            // Conditional actions go here and below
            if(sortResidentInfo() || viewResidentProfile()){
                currentMenu.setViewResidentMenu();
                currentMenu.resetSelectedOptions();
            }
            if(viewSalesInfo() && !viewAggregated()){
                currentMenu.setViewSalesMenu();
                currentMenu.resetSelectedOptions();
                currentMenu.setGreeting(null);
            }
            if(isAdvancingNext()){
                endDay();
                joestars.setDay(time.getDayCount());
                joestars.assignFoodToResidents();
                currentMenu.setCurrentOption(-1); // -1 ensures that the menu works properly
                currentMenu.defineOptions();
                currentMenu.setDefaultOption();
            }
            if(movingLocations()){
                if(returnPreviousLocation()){
                    currentMenu.setReturnPreviousLocation(false);
                    map.moveBack();
                }
                else if(moveTownHall()){
                    currentMenu.setMoveTownHall(false);
                    map.moveTownHall();
                }
                else if(wantMoveForward()){
                    currentMenu.setWantMoveForward(false);
                    map.moveForward();
                    currentMenu.setHasForwardAdded(false);
                }
                else{
                    currentMenu.setMovingLocations(false);
                    map.clearForwardLocations();
                    map.moveTo(executeOutput);
                }
                currentMenu.setMovingLocations(false);
                currentMenu.setGreeting(null);
                setCurrentMenu(getCurrentLocation().getMenu());
                currentMenu.setCurrentOption(-1);
                currentMenu.defineOptions();
                currentMenu.setDefaultOption();
                if(hasForwardLocation()){
                    currentMenu.setHasForwardAdded(false);
                }
            }
        }
    }
}

/* Purpose: Keeps track of game time */
class Clock{
    private int dayCount;
    private int dayOfWeek; // every week's first day is Sunday

    public Clock(){
        this.dayCount = this.dayOfWeek = 1;
    }

    /* Method A: Getter and setter methods */
    
    /* Returns a string describing the current day */
    public String dayInfo(){
        return "It's Day " + this.dayCount + " (" + computeDay(this.dayOfWeek) + ") of our journey in JOJOLands!";
    }

    /* Method B: Display methods */

    /* Method C: Processing methods */

    /* Returns a string of the current day according to the numeric input, dayCount */
    public String computeDay(int dayOfWeek){
        String day = "";
        switch(dayOfWeek){
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }

    /* Purpose: Updates all of the relevant variables when a day ends */
    public void endDay(){
        dayCount++;
        if(dayOfWeek == 7){dayOfWeek = 1;}
        else{dayOfWeek++;}
    }

    public int getDayCount(){
        return this.dayCount;
    }

    public void setDayCount(int dayCount){
        this.dayCount = dayCount;
    }

    public void setDayOfWeek(int dayCount){
        this.dayOfWeek = dayCount % 7;
    }
}