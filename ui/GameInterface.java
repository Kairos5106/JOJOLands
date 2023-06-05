package DSTeam3.ui;

import DSTeam3.maps.base.*;
import DSTeam3.ui.base.Menu;
import DSTeam3.ui.base.UserInterface;
import java.util.ArrayList;
import DSTeam3.maps.*;
import DSTeam3.maps.base.Map;
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

public class GameInterface extends UserInterface{
    /* Instance variables */
    private Clock time = new Clock(); // keeps track of the time in-game
    private boolean newDay = true; // to help with notifying the player with current day count and day name
    Map map;
    ArrayList<Menu> listOfLocationMenus = new ArrayList<>(); // holds all of the menu interfaces of each location as well as the special functions

    /* Constructors */
    public GameInterface(){}

    public GameInterface(Map map){
        this.map = map;
    }

    public GameInterface(Map map, Menu menu){
        this.map = map;
        this.currentMenu = menu;
    }

    /* ****************** Method A: Getter and setter methods ****************** */

    public String getDayInfo(){
        return time.dayInfo();
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
        map.defineLocations();
        presetListOfMenus();
        setCurrentMenu(getCurrentMenu());
        currentMenu.defineOptions();
        currentMenu.setDefaultOption();
        String input = "";
        divider(70);
        while(!getExitInterface()){
            String executeOutput = "";
            if(isNewDay()){
                currentMenu.setNewDayGreeting(getDayInfo());
                setNewDay(false);
            }
            currentMenu.runDisplay();

            /* Debugging statement for nearby nodes of currentLocation */
            // String[] nearbyLocationList = getNearbyLocationNames();
            // for (int i = 0; i < nearbyLocationList.length; i++) {
            //     System.out.println(nearbyLocationList[i]);
            // }

            input = prompt("Select: ", currentMenu.getMaxOptionRange());
            currentMenu.setSelected(Integer.parseInt(input)-1);
            divider(70);
            executeOutput = currentMenu.execute(input);
            currentMenu.setCurrentOption(Integer.parseInt(input)-1);
            
            // Conditional actions go here and below
            if(isAdvancingNext()){ // at town hall
                endDay();
                currentMenu.setCurrentOption(-1); // -1 ensures that the menu works properly
                currentMenu.defineOptions();
                currentMenu.setDefaultOption();
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
}