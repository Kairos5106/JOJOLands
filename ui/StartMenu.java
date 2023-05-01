package DSTeam3.ui;

import DSTeam3.maps.*;
import DSTeam3.maps.base.*;
import DSTeam3.ui.base.*;

public class StartMenu extends Menu{ 
    /* Instance variables */
    private Map map;
    
    public StartMenu(){
        super();
    }

    /* Getter and setter methods */
    public void setMap(Map map){
        this.map = map;
    }

    @Override
    public Map getMap(){
        return this.map;
    }

    /* Purpose: Defines the options for the menu */
    @Override
    public void defineOptions(){
        // Define start menu elements
        setGreeting("Welcome, to the fantastical realm of JOJOLands."); // first greeting

        // Defining options and linking them to their respective suboptions
        Option start = new Option("Start Game");
        start.addSuboptions("Default Map");
        start.addSuboptions("Parallel Map");
        start.addSuboptions("Alternate Map");
        
        Option load = new Option("Load Game");
        load.addSuboptions("Not developed yet");
        
        Option exit = new Option("Exit");

        Option[] startMenuOptions = {start, load, exit};
        addOptions(startMenuOptions);
    }

    @Override
    public void execute(String inputStr){
        switch(getSelectedTitle()){
            case "Start Game":
                setGreeting("Select a map: ");
                break;
            case "Default Map":
                setMap(new DefaultMap());
                System.out.printf("You have selected: %s\n", getMap().getMapName());
                setExitInterface(true);
                break;
            case "Parallel Map":
                setMap(new ParallelMap());
                System.out.printf("You have selected: %s\n", getMap().getMapName());
                setExitInterface(true);
                break;
            case "Alternate Map":
                setMap(new AlternateMap());
                System.out.printf("You have selected: %s\n", getMap().getMapName());
                setExitInterface(true);
                break;
            case "Load Game":
                setGreeting("Enter the path of your save file");
                System.out.println("Not developed yet");
                break;
            case "Exit":
                setExitInterface(true);
                setExitGame(true);
                System.out.println("Exiting JOJOlands...");
                break;
        }
    }
}