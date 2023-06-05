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

    public Menu getMenu(){
        return this.map.getCurrentMenu();
    }

    public void presetListOfMenus(){
        listOfLocationMenus.add(new TownHallMenu());
        listOfLocationMenus.add(new MoriohGrandMenu());
        listOfLocationMenus.add(new TrattoriaTrussardiMenu());
        listOfLocationMenus.add(new GreenDolphinMenu());
        listOfLocationMenus.add(new LibeccioMenu());
        listOfLocationMenus.add(new SanGiorgioMenu());
        listOfLocationMenus.add(new JadeGardenMenu());
        listOfLocationMenus.add(new CafeDeuxMenu());
        listOfLocationMenus.add(new JoestarMansionMenu());
        listOfLocationMenus.add(new DioMansionMenu());
        listOfLocationMenus.add(new AngeloRockMenu());
        listOfLocationMenus.add(new VineyardMenu());
        listOfLocationMenus.add(new SavageGardenMenu());
        listOfLocationMenus.add(new PolnareffLandMenu());
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
        presetListOfMenus();

        

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
            input = prompt("Select: ", currentMenu.getMaxOptionRange());
            currentMenu.setSelected(Integer.parseInt(input)-1);
            divider(70);
            executeOutput = currentMenu.execute(input);
            currentMenu.setCurrentOption(Integer.parseInt(input)-1);
            
            // Conditional actions go here and below
            if(isAdvancingNext()){ // at town hall
                time.endDay();
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