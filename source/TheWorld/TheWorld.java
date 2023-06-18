package DSTeam3.source.TheWorld;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class TheWorld {
    static HashMap<Integer, GameState> availableSaveFiles = new HashMap<>();
    static String filePath = "DSTeam3\\source\\TheWorld\\saves\\saveFile_"; // to append save file name at the end

    public TheWorld(){
        detectAvailableSaveFiles();
    }

    public static void detectAvailableSaveFiles(){
        
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
}
