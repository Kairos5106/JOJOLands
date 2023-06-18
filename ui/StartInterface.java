package DSTeam3.ui;

import DSTeam3.ui.base.*;
import DSTeam3.maps.base.Map;
import DSTeam3.source.TheWorld.TheWorld;

public class StartInterface extends UserInterface{
    /* Instance variables */
    TheWorld world = new TheWorld();

    /* Constructor */
    public StartInterface(){
        super();
    }
    
    public StartInterface(Menu menu){
        super(menu);
    }

    /* Method A: Getter and setter methods */

    public Map getMapSelected(){
        return this.currentMenu.getMap();
    }

    public boolean loadSaveFile(){
        return currentMenu.loadSaveFile();
    }

    public TheWorld getWorld(){
        return world;
    }

    /* Method B: Display methods */

    /* Method C: Processing methods */
    @Override
    public void initiate(){
        currentMenu.defineOptions();
        String input = "";
        divider(70);
        while(!getExitInterface()){
            currentMenu.runDisplay();
            input = prompt("Select: ", currentMenu.getMaxOptionRange());
            currentMenu.setSelected(Integer.parseInt(input)-1, true);
            divider(70);
            currentMenu.execute(input);
            currentMenu.setCurrentOption(Integer.parseInt(input)-1);
            if(loadSaveFile()){
                world.detectAvailableSaveFiles();
                world.displayAvailableSaveFiles();
                world.promptSaveFile();
            }
        }
    }
}