package DSTeam3.source.TheWorld;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import DSTeam3.source.Joestars.TheJoestars;
import DSTeam3.source.MilagroMan.MilagroMan;
import java.util.List;

/* Keeps track of the current state of the game and the essential variables to account for in a game */
public class GameState {
    private LocalDateTime currentDateTime; // keeps track of when save file was last created/overwritten
    
    // Game state is save and loaded in this order starting from mapName
    private String mapName;
    private int dayCount;
    private String currentDateTimeStr;
    private List<String[]> saleEntries; // a copy of AssignFood.csv

    public GameState(){
        mapName = "";
        dayCount = 0;
        saleEntries = new ArrayList<>();
    }

    public void setSaleEntries(List<String[]> saleEntries){
        this.saleEntries = saleEntries;
    }

    public List<String[]> getSaleEntries(){
        return this.saleEntries;
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
                if(line.equals("assignfood")){
                    break;
                }
                information.add(line.split("=")[1]);
            }
            String[] informationArray = new String[information.size()];
            for (int i = 0; i < information.size(); i++) {
                informationArray[i] = information.get(i);
            }
            loadSaveFile(informationArray);

            // Saving AssignFood data
            List<String[]> saleEntries = new ArrayList<>();
            while(in.hasNextLine()){
                String line = in.nextLine();
                String[] entry = line.split(",");
                saleEntries.add(entry);
            }
            setSaleEntries(saleEntries);
            in.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveFoodFile(){
        String filePath = (new TheJoestars()).getFilePath();
        List<String[]> saleEntries = new ArrayList<>();
        try{
            Scanner in = new Scanner(new FileInputStream(filePath));
            while(in.hasNextLine()){
                String line = in.nextLine();
                String[] row = line.split(",");
                saleEntries.add(row);
            }
            in.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        setSaleEntries(saleEntries);
    }

    public void loadFoodFile(){
        String filePath = (new TheJoestars()).getFilePath();
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(filePath));
            for (String[] entry : saleEntries) {
                String day = entry[0];
                String residentName = entry[1];
                String age = entry[2];
                String gender = entry[3];
                String location = entry[4];
                String menuItem = entry[5];
                String price = entry[6];
                String time = entry[7];
                writer.printf("%s,%s,%s,%s,%s,%s,%s,%s\n", day, residentName, age, gender, location, menuItem, price, time);
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
