package DSTeam3.source.TheWorld;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/* Keeps track of the current state of the game and the essential variables to account for in a game */
public class GameState {
    private LocalDateTime currentDateTime; // keeps track of when save file was last created/overwritten
    
    // Game state is save and loaded in this order starting from mapName
    private String mapName;
    private int dayCount;
    private String currentDateTimeStr;

    public GameState(){
        mapName = "";
        dayCount = 0;
    }

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
        return this.currentDateTimeStr;
    }

    public void setCurrentDateTimeStr(String currentDateTimeStr){
        this.currentDateTimeStr = currentDateTimeStr;
    }

    public LocalDateTime getCurrentDateTime(){
        return this.currentDateTime;
    }

    public void setCurrentDateTimeToNow(){
        this.currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        setCurrentDateTimeStr(dateFormat.format(getCurrentDateTime()));
    }

    public void loadSaveFile(String[] information){
        setMapName(information[0]);
        setDayCount(Integer.parseInt(information[1]));
        setCurrentDateTimeStr(information[2]);
    }

    public void loadSaveFile(String filePathToLoad){
        try{
            Scanner in = new Scanner(new FileInputStream(filePathToLoad));
            ArrayList<String> information = new ArrayList<>();
            while(in.hasNextLine()){
                String line = in.nextLine();
                information.add(line.split("=")[1]);
            }
            String[] informationArray = new String[information.size()];
            for (int i = 0; i < information.size(); i++) {
                informationArray[i] = information.get(i);
            }
            loadSaveFile(informationArray);
            in.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
