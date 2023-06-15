package DSTeam3.ui.base;

import java.util.ArrayList;
import DSTeam3.maps.base.Map;

/* Purpose: Handles everything that is to do with menu option selection */
public class Menu{
    /* Instance variables */
    protected ArrayList<Option> options = new ArrayList<>();
    private Option currentOption = null;
    protected ArrayList<Boolean> optionsPrintIndent = new ArrayList<>(); // if true, print suboptions indented on the same page

    String greeting; // represent text that appears before the options show up
    String locationName; // optional string variable: for nodes in map only
    String currentMapName;

    boolean exitGame = false;
    boolean exitInterface = false;
    boolean advanceNextDay = false;
    boolean openMoveLocationsMenu = false;
    boolean movingLocations = false;
    boolean returnPreviousLocation = false;
    boolean returnToFrontPage = false;
    boolean moveTownHall = false;
    boolean wantMoveForward = false;
    boolean hasForwardAdded = false;
    boolean viewResidentInfo = false;
    boolean sortResidentInfo = false;
    boolean initialiseGoldenSpirit = false;

    /* Constructors */
    public Menu(){
        this.greeting = null;
        this.locationName = null;
    }

    public Menu(String locationName){
        this.locationName = locationName;
    }

    public Menu(String greeting, String locationName){
        this.greeting = greeting;
        this.locationName = locationName; // set to null if not used
    }

    public Menu(String greeting, String locationName, String currentMapName){
        this.greeting = greeting;
        this.locationName = locationName;
        this.currentMapName = currentMapName;
    }
    
    /* ****************** Methods A: Getter and setter methods ****************** */

    /* Special case: If a value of -1 is input, the current option will be set to null */
    public void setCurrentOption(int indexOfSuboption){
        if(indexOfSuboption == -1){
            this.currentOption = null;
        }
        else{
            this.currentOption = this.currentOption.get(indexOfSuboption);
        }
    }

    /* Overlaod method */
    public void setCurrentOption(int indexOfSuboption, boolean setting){
        if(setting){ // true
            this.currentOption = options.get(indexOfSuboption);
        }
        else{
            if(indexOfSuboption == -1){
                this.currentOption = null;
            }
            else{
                this.currentOption = this.currentOption.get(indexOfSuboption);
            }
        }
    }

    public Option getCurrentOption(){
        return this.currentOption;
    }
    
    public String getSuboptionTitle(int index){
        return this.getSuboptionTitle(index);
    }

    /* Purpose: Marks which suboption that has been selected */
    public void setSelected(int index, boolean setting){
        currentOption.setSelected(index, setting);
    }
    
    /* Purpose: Returns the index of the suboption that was selected */
    public int getSelected(){
        return this.currentOption.getSelected();
    }

    public String getSelectedTitle(){
        return this.currentOption.getSuboptionTitle(getSelected());
    }

    public boolean selectedTitleEquals(String titleToCompare){
        if(getSelectedTitle().equals(titleToCompare)){
            return true;
        }
        return false;
    }

    public void setExitGame(boolean exitGame){
        this.exitGame = exitGame;
    }

    public boolean getExitGame(){
        return this.exitGame;
    }

    /* Purpose: Adds some option(s) into the 'options' instance variable
     * @param options: an array of Option objects
     */
    public void addOptions(Option[] options){
        for (int i = 0; i < options.length; i++) {
            this.options.add(options[i]);
        }
    }

    /* Purpose: Clears the current options and adds the input options into the 'options' instance variable */
    public void setOptions(Option[] options){
        clearOptions();
        addOptions(options);
    }

    /* Purpose: Clears the current options list */
    public void clearOptions(){
        options.clear();
    }

    /* Purpose: Sets the greeting */
    public void setGreeting(String greeting){
        this.greeting = greeting;
    }

    /* Purpose: Returns the numerical max range of options that can be selected */
    public int getMaxOptionRange(){
        if(currentOption == null){
            return this.options.size();
        }
        else{
            return this.currentOption.getSuboptionsCount();
        }
    }

    public Map getMap(){return null;} // placeholder for subclasses to override

    public void setExitInterface(boolean exitInterface){
        this.exitInterface = exitInterface;
    }

    public boolean getExitInterface(){
        return this.exitInterface;
    }
    
    public void setLocationName(String locationName){
        this.locationName = locationName;
    }

    public String getLocationName(){
        return this.locationName;
    }

    public void setAdvanceNextDay(boolean advanceNextDay){
        this.advanceNextDay = advanceNextDay;
    }

    public boolean getAdvanceNextDay(){
        return this.advanceNextDay;
    }

    public void setDefaultOption(){
        if(getCurrentOption() == null){
            Option defaultOption = new Option();
            for (int i = 0; i < options.size(); i++) {
                defaultOption.addSuboptions(options.get(i));
            }
            currentOption = defaultOption;
        }
    }
    
    public void setOpenMoveLocationsMenu(boolean setting){
        this.openMoveLocationsMenu = setting;
    }

    public boolean getOpenMoveLocationsMenu(){
        return this.openMoveLocationsMenu;
    }

    public void setMovingLocations(boolean setting){
        this.movingLocations = setting;
    }

    public boolean movingLocations(){
        return this.movingLocations;
    }

    public void setReturnPreviousLocation(boolean setting){
        this.returnPreviousLocation = setting;
    }

    public boolean returnPreviousLocation(){
        return this.returnPreviousLocation;
    }

    public void setReturnToFrontPage(boolean setting){
        this.returnToFrontPage = setting;
    }

    public boolean returnToFrontPage(){
        return this.returnToFrontPage;
    }

    public void setMoveTownHall(boolean setting){
        this.moveTownHall = setting;
    }

    public boolean moveTownHall(){
        return this.moveTownHall;
    }

    public void setWantMoveForward(boolean setting){
        this.wantMoveForward = setting;
    }

    public boolean wantMoveForward(){
        return this.wantMoveForward;
    }

    public void setCurrentMapName(String currentMapName){
        this.currentMapName = currentMapName;
    }

    public String getCurrentMapName(){
        return this.currentMapName;
    }

    public void setHasForwardAdded(boolean setting){
        this.hasForwardAdded = setting;
    }

    public boolean hasForwardAdded(){
        return this.hasForwardAdded;
    }
    
    public void setViewResidentInfo(boolean setting){
        this.viewResidentInfo = setting;
    }
    
    public boolean viewResidentInfo(){
        return this.viewResidentInfo;    
    }

    public void setSortResidentInfo(boolean setting){
        this.sortResidentInfo = setting;
    }

    public boolean sortResidentInfo(){
        return this.sortResidentInfo;
    }

    // 
    public void setInitialiseGoldenSpirit(boolean setting){
        this.initialiseGoldenSpirit = setting;
    }

    public boolean initialiseGoldenSpirit(){
        return this.initialiseGoldenSpirit;
    }

    /* ****************** Methods B: Display methods ****************** */

    public void printGreeting(){
        if(this.greeting == null){return;}
        System.out.println(this.greeting);
    }

    public void printLocation(){
        if(this.locationName == null){return;} // cancels method if locationName is null
        System.out.println("Current Location: " + this.locationName);
    }

    /* Purpose: Prints the selection number followed by the option title by a row-by-row basis. */
    public void printOptions(){
        setDefaultOption();
        for (int i = 0; i < currentOption.getSuboptionsCount(); i++) {
            System.out.printf("[%s] %s\n", i+1, currentOption.getSuboptionTitle(i));
        }
        System.out.println();
    }

    /* Purpose: Displays the menu greeting, locationName and options.
     * Note: If any of the these are null, it won't be printed
     */
    public void runDisplay(){
        printLocation();
        System.out.println();
        printGreeting();
        printOptions();
    }
    
    /* Methods C: Processing methods - Everything aside from A and B */

    public void defineOptions(){ // placeholder for subclasses to override
        // Define menu options along with their respective suboptions
    }

    public void defineOptions(String[] nearbyLocationNames){}

    public String execute(String inputStr){ // placeholder for subclasses to override
        // Define commands that are associated with their respective inputs
        return "";
    }

    public void execute(String inputStr, String[] nearbyLocationNames){}

    public void setNewDayGreeting(String newDayGreeting){}

    public void setViewResidentMenu(){
        setCurrentOption(1, true); // Make sure the option to view resident info is at index = 1 at every relevant location
    }
}