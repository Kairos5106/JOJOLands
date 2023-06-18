package DSTeam3.source.TheWorld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* Keeps track of the current state of the game and the essential variables to account for in a game */
public class GameState {
    private String mapName;
    private int dayCount;
    private LocalDateTime currentDateTime; // keeps track of when save file was last created/overwritten

    public GameState(){}

    public void setMapName(String mapName){
        this.mapName = mapName;
    }

    public String getMapName(){
        return this.mapName;
    }

    public int getDayCount(){
        return this.dayCount;
    }

    public void setDayCount(int dayCount){
        this.dayCount = dayCount;
    }

    public String getCurrentDateTimeStr(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return currentDateTime.format(dateFormat);
    }

    public void setCurrentDateTime(){
        this.currentDateTime = LocalDateTime.now();
    }
}
