/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.MoodyBlues;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import DSTeam3.source.Joestars.TheJoestars;
import java.util.*;

/**
 *
 * @author firza
 */
public class MoodyBlues {
    public static void main(String[] args) {
        MoodyBlues test = new MoodyBlues();
        test.setName("Jade Garden");
        test.readFile();
        System.out.println("Day count: " + test.dayCount);
    }

    static String restaurantName;
    static List<String[]> saleEntries; // basically a copy of AssignFood.csv except only has entries of location = restaurantName
    static int dayCount;

    public MoodyBlues() {}

    public int getEntryCount(){
        return saleEntries.size();
    }

    public List<String[]> getSales() {
        return saleEntries;
    }

    public void setSaleEntries(List<String[]> saleEntries){
        this.saleEntries = saleEntries;
    }

    public double getTotalSales() {
        double totalSales = 0.0;
        for (String[] entry : saleEntries) {
            totalSales += Double.parseDouble(entry[6]); // index 6 refers to column 7 (price) in AssignFood.csv
        }
        return totalSales;
    }

    public double getAverageSales() {
        return getTotalSales() / saleEntries.size();
    }

    public int getQuantityForFood(String foodName) {
        int quantity = 0;
        for (String[] entry : saleEntries) {
            if (entry[5].equals(foodName)) {
                quantity++;
            }
        }
        return quantity;
    }

    public void readFile(){
        // Getting sale entries
        String filePath = (new TheJoestars().getFilePath());
        List<String[]> saleEntries = new ArrayList<>();
        int maxDays = 0;
        try{
            Scanner in = new Scanner(new FileInputStream(filePath));
            in.nextLine(); // skip header row
            while(in.hasNextLine()){
                String line = in.nextLine();
                String[] row = line.split(",");
                if(row[4].equals(restaurantName)){
                    saleEntries.add(row);
                }
                // Getting day range of sale entries
                if(Integer.parseInt(row[0]) > maxDays){
                    maxDays = Integer.parseInt(row[0]);
                }
            }
            in.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        setSaleEntries(saleEntries);
        dayCount = maxDays;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    // Method: Displays the saleEntries information for a specific day.
    // Parameters:
    // - day: The day for which the saleEntries information should be displayed.
    public void displaySales(int day) {
        if (day <= 0 || day > dayCount) {
            System.out.println("Invalid day!");
            return;
        }

        // Filtering out the entries corresponding to "day" and putting the food as an entry into the foodIndo hashmap
        List<String[]> saleEntriesCopy = new ArrayList<>(saleEntries);
        HashMap<String, double[]> foodInfo = new HashMap<>(); // key = food name, value = {quantity, price, total price}

        for (String[] entry : saleEntriesCopy) {
            if((Integer.parseInt(entry[0]) == day)){
                String foodName = entry[5];
                double[] foodInformation;
                double quantity;
                double price;
                double totalPrice;
                if(!foodInfo.containsKey(foodName)){
                    quantity = 1;
                    price = totalPrice = Double.parseDouble(entry[6]);
                    foodInformation = new double[]{quantity, price, totalPrice};   
                    foodInfo.put(foodName, foodInformation);
                }
                else{
                    foodInformation = foodInfo.get(foodName);
                    quantity = foodInformation[0] + 1;
                    price = foodInformation[1];
                    totalPrice = quantity * price;
                    foodInfo.put(foodName, new double[]{quantity, price, totalPrice});
                }
            }
        }
        
        // Calculate total sales for the day
        double totalSales = 0;
        for (String foodName : foodInfo.keySet()) {
            double[] foodInformation = foodInfo.get(foodName);
            totalSales += foodInformation[2];
        }

        // Display the saleEntries information in a formatted table.
        System.out.println("Restaurant: " + restaurantName);
        System.out.println("Day " + day + " Sales");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");
        for (String foodName : foodInfo.keySet()) {
            double[] foodInformation = foodInfo.get(foodName);
            System.out.printf("| %-35s | %8d | $%10.2f |\n", foodName, (int)(foodInformation[0]), foodInformation[2]);
        }
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.printf("| Total Sales                         |          | $%10.2f |\n", totalSales);
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println();
    }
    
    public double getMinimumSales() {
        HashMap<Integer, Double> totalSalesByDay = new HashMap<>();
        List<String[]> saleEntriesCopy = new ArrayList<>(saleEntries);
        
        for (int i = 0; i < saleEntriesCopy.size(); i++) {
            String[] entry = saleEntriesCopy.get(i);
            int day = Integer.parseInt(entry[0]);
            double totalSales = 0;
            if(!totalSalesByDay.containsKey(day)){ // does not have day
                totalSales = Double.parseDouble(entry[6]);
                totalSalesByDay.put(day, totalSales);
            }
            else{ // does contain day
                totalSales = totalSalesByDay.get(day) + Double.parseDouble(entry[6]);
                totalSalesByDay.put(day, totalSales);
            }
        }
        
        double minimumSales = totalSalesByDay.get(1);
        for (Integer day : totalSalesByDay.keySet()) {
            double sales = totalSalesByDay.get(day);
            if(minimumSales > sales){
                minimumSales = sales;
            }
        }
        return minimumSales;
    }

    public double getMaximumSales() {
        HashMap<Integer, Double> totalSalesByDay = new HashMap<>();
        List<String[]> saleEntriesCopy = new ArrayList<>(saleEntries);
        
        for (int i = 0; i < saleEntriesCopy.size(); i++) {
            String[] entry = saleEntriesCopy.get(i);
            int day = Integer.parseInt(entry[0]);
            double totalSales = 0;
            if(!totalSalesByDay.containsKey(day)){ // does not have day
                totalSales = Double.parseDouble(entry[6]);
                totalSalesByDay.put(day, totalSales);
            }
            else{ // does contain day
                totalSales = totalSalesByDay.get(day) + Double.parseDouble(entry[6]);
                totalSalesByDay.put(day, totalSales);
            }
        }
        
        double maximumSales = totalSalesByDay.get(1);
        for (Integer day : totalSalesByDay.keySet()) {
            double sales = totalSalesByDay.get(day);
            if(maximumSales < sales){
                maximumSales = sales;
            }
        }
        return maximumSales;
    }

    public void displayTopHighestSales(int k) {
        List<String[]> saleEntriesCopy = new ArrayList<>(saleEntries);
        HashMap<String, double[]> foodInfo = new HashMap<>(); // key = food name, value = {quantity, price, total price}

        for (String[] entry : saleEntriesCopy) {
            String foodName = entry[5];
            double[] foodInformation;
            double quantity;
            double price;
            double totalPrice;
            if(!foodInfo.containsKey(foodName)){
                quantity = 1;
                price = totalPrice = Double.parseDouble(entry[6]);
                foodInformation = new double[]{quantity, price, totalPrice};   
                foodInfo.put(foodName, foodInformation);
            }
            else{
                foodInformation = foodInfo.get(foodName);
                quantity = foodInformation[0] + 1;
                price = foodInformation[1];
                totalPrice = quantity * price;
                foodInfo.put(foodName, new double[]{quantity, price, totalPrice});
            }
        }

        // Moving foodInto into an arraylist
        List<String[]> foodsByHighestSales = new ArrayList<>();
        int initialFoodInfoSize = foodInfo.size();
        for (int i = 0; i < initialFoodInfoSize; i++) {
            String foodName;
            String foodNameWithHighest = "";
            double highestSales = 0;
            double[] info;
            for (String nameOfFood : foodInfo.keySet()) {
                foodName = nameOfFood;
                info = foodInfo.get(foodName);
                if(highestSales < info[2]){
                    highestSales = info[2];
                    foodNameWithHighest = foodName;
                }
            }
            foodInfo.remove(foodNameWithHighest);
            String[] contents = new String[]{foodNameWithHighest, String.format("%.2f", highestSales)};
            foodsByHighestSales.add(contents);
        }

        System.out.println("Restaurant: " + restaurantName);
        System.out.println("Top " + k + " Highest Sales");
        System.out.println("+----+----------------------------------------------------+--------------+");
        System.out.println("| No | Food                                               | Total Sales  |");
        System.out.println("+----+----------------------------------------------------+--------------+");
        int index = 1;
        for (int i = 0; i < k ; i++) {
            String[] contents = foodsByHighestSales.get(i);
            System.out.printf("| %-2d | %-51s| $%11.2f |\n", index++, contents[0], Double.parseDouble(contents[1]));
        }
        System.out.println("+----+----------------------------------------------------+--------------+");
        System.out.println();
    }

    public void displayTotalAndAverageSales(int startDay, int endDay) {
        int numberOfDays = endDay - startDay + 1;

        List<String[]> saleEntriesCopy = new ArrayList<>(saleEntries);
        HashMap<String, double[]> foodInfo = new HashMap<>(); // key = food name, value = {quantity, price, total price}

        for (String[] entry : saleEntriesCopy) {
            if((Integer.parseInt(entry[0]) >= startDay || Integer.parseInt(entry[0]) <= endDay)){
                String foodName = entry[5];
                double[] foodInformation;
                double quantity;
                double price;
                double totalPrice;
                if(!foodInfo.containsKey(foodName)){
                    quantity = 1;
                    price = totalPrice = Double.parseDouble(entry[6]);
                    foodInformation = new double[]{quantity, price, totalPrice};   
                    foodInfo.put(foodName, foodInformation);
                }
                else{
                    foodInformation = foodInfo.get(foodName);
                    quantity = foodInformation[0] + 1;
                    price = foodInformation[1];
                    totalPrice = quantity * price;
                    foodInfo.put(foodName, new double[]{quantity, price, totalPrice});
                }
            }
        }
        
        // Calculate total sales for the range of days
        double totalSales = 0;
        for (String foodName : foodInfo.keySet()) {
            double[] foodInformation = foodInfo.get(foodName);
            totalSales += foodInformation[2];
        }
        double averageSales = totalSales / numberOfDays;

        System.out.println("Restaurant: " + restaurantName);
        System.out.printf("Total and Average Sales (Day %d - %d)\n", startDay, endDay);
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");


        // Display the aggregated information
        for (String foodName : foodInfo.keySet()) {
            double[] contents = foodInfo.get(foodName);
            double quantity = contents[0];
            double totalPriceForFood = contents[2];
            System.out.printf("| %-35s | %8d | $%10.2f |\n", foodName, (int)quantity, totalPriceForFood);
        }
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.printf("| Total Sales                         |          | $%10.2f |\n", totalSales);
        System.out.printf("| Average Sales                       |          | $%10.2f |\n", averageSales);
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println();
    }
}