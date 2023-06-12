package DSTeam3.ui;

import DSTeam3.ui.base.*;
import DSTeam3.maps.base.Map;

public class StartInterface extends UserInterface{
    /* Instance variables */

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

    /* Method B: Display methods */

    /* Method C: Processing methods */
    
}