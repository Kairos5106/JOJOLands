package DSTeam3.source.TheWorld;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class TheWorld {
    static HashMap<Integer, GameState> availableSaveFiles = new HashMap<>();
    static String filePath = "DSTeam3\\source\\TheWorld\\saves\\saveFile_"; // to append save file name at the end
    static String filePathToLoad = "";
    static GameState gameStateToLoad = null;

    public TheWorld(){
        detectAvailableSaveFiles();
    }

    public static void detectAvailableSaveFiles(){
        int count = 1;
        String specificFilePath = filePath + String.format("%d", count);
        File file = new File(specificFilePath);

        while(file.exists()){
            GameState gameStateToDetect = null;
            try{
                Scanner in = new Scanner(new FileInputStream(file));
                ArrayList<String> information = new ArrayList<>();
                while(in.hasNextLine()){
                    String line = in.nextLine();
                    information.add(line.split("=")[1]);
                }
                gameStateToDetect = new GameState();
                String[] informationArray = new String[information.size()];
                for (int i = 0; i < information.size(); i++) {
                    informationArray[i] = information.get(i);
                }
                gameStateToDetect.loadSaveFile(informationArray);
                in.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
            availableSaveFiles.put(count, gameStateToDetect);
            count++;
            specificFilePath = filePath + count;
            file = new File(specificFilePath);
        }
    }

    public static void displayAvailableSaveFiles(){
        for (Integer key : availableSaveFiles.keySet()) {
            GameState gameStateToDisplay = availableSaveFiles.get(key);
            String dateCreated = gameStateToDisplay.getCurrentDateTimeStr();
            String mapName = gameStateToDisplay.getMapName();
            String dayCount = Integer.toString(gameStateToDisplay.getDayCount());
            System.out.printf("** Save File %d **\n" +
                                "\tDate created\t: %s\n" +
                                "\tMap\t\t: %s\n" +
                                "\tCurrent day\t: %s\n\n", key, dateCreated, mapName, dayCount);
        }
    }

    public static void saveGame(GameState gameState){
        String specificFilePath = filePath + String.format("%d", availableSaveFiles.size() + 1);
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(specificFilePath));
            writer.printf("mapName=%s\n", gameState.getMapName());
            writer.printf("dayCount=%d\n", gameState.getDayCount());
            writer.printf("dateCreated=%s", gameState.getCurrentDateTimeStr()); // no newline at last line
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        // Inform user of creation of save file and its details
        System.out.printf("Successfully created save file dated " + gameState.getCurrentDateTimeStr() + "\n");
    }

    public void promptSaveFile(){
        System.out.print("Enter save file index to load: ");
        Scanner in = new Scanner(System.in);
        int saveFileIndex = in.nextInt();
        filePathToLoad = filePath + String.format("%d", saveFileIndex);
        in.close();
        gameStateToLoad.loadSaveFile(filePathToLoad);
    }

    public GameState getGameStateToLoad(){
        return gameStateToLoad;
    }
}
