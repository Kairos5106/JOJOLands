package DSTeam3.source.MilagroMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import DSTeam3.source.Joestars.*;

public class MilagroMan {
    static String restaurantName;
    static List<String[]> saleEntries; // basically a copy of AssignFood.csv
    static String filePathModified = "DSTeam3\\source\\AssignFoodModded.csv";
    static HashMap<String, String[]> foodNameToChanges = new HashMap<>(); // key = food name, value = {price, startDay, endDay}

    public void setRestaurantName(String name){
        restaurantName = name;
    }

    public static void setSaleEntries(List<String[]> saleEntriesList){
        saleEntries = saleEntriesList;
    }

    public static List<String[]> getSaleEntries(){
        return saleEntries;
    }

    public static void readFile(){
        // Getting sale entries
        String filePath = (new TheJoestars().getFilePath());
        List<String[]> saleEntries = new ArrayList<>();
        try{
            Scanner in = new Scanner(new FileInputStream(filePath));
            in.nextLine(); // skip header row
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

    public static String getFilePath(){
        return filePathModified;    
    }

    public static void promptModifyFoodPrice() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter food name\t: ");
        String foodName = in.nextLine();
        System.out.print("Enter new price\t: $");
        double price = in.nextDouble();
        System.out.print("Enter start day\t: ");
        int startDay = in.nextInt();
        System.out.print("Enter end day\t: ");
        int endDay = in.nextInt();

        String startDayStr = Integer.toString(startDay);
        String endDayStr = Integer.toString(endDay);
        String priceStr = String.format("%.2f", price);

        foodNameToChanges.put(foodName, new String[]{priceStr, startDayStr, endDayStr});
    }

    public static void generateSaleEntries(){
        // Scan arraylist for foodName and day. If found, make a copy of string array and modify prices
        for (String foodName: foodNameToChanges.keySet()) {
            double price = Double.parseDouble(foodNameToChanges.get(foodName)[0]);
            int startDay = Integer.parseInt(foodNameToChanges.get(foodName)[1]);
            int endDay = Integer.parseInt(foodNameToChanges.get(foodName)[2]);
            // System.out.println("startDay="+startDay); // Debug
            // System.out.println("endDay="+endDay); // Debug
            // System.out.println("foodName="+foodName); // Debug
            // System.out.println("price="+price); // Debug
            for (int i = 0; i < saleEntries.size(); i++) {
                String[] entry = saleEntries.get(i);
                int dayOfEntry = Integer.parseInt(entry[0]);
                if((dayOfEntry >= startDay) && (dayOfEntry <= endDay) && (entry[5].equalsIgnoreCase(foodName))){
                    entry[6] = String.format("%.2f", price);
                    saleEntries.remove(i);
                    saleEntries.add(entry);
                }
            }
        }

        // Generate a new file called AssignFoodModded.csv
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(filePathModified));
            writer.write("Day,Name,Age,Gender,Location,MenuItem,Price,Time\n");
            for (String[] entry : saleEntries) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n", entry[0], entry[1], entry[2], entry[3], entry[4], entry[5], entry[6], entry[7]));
            }
            writer.close();
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public static void resetVar(){
        foodNameToChanges.clear();
    }
}
