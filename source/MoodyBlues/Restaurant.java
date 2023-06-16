/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.MoodyBlues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author firza
 */
public class Restaurant {

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dailySales
     */
    public List<SalesInformation> getDailySales() {
        return dailySales;
    }

    /**
     * @param dailySales the dailySales to set
     */
    public void setDailySales(List<SalesInformation> dailySales) {
        this.dailySales = dailySales;
    }
    
    private String name;
    private List<SalesInformation> dailySales;

    // Constructor: Initializes a new instance of the Restaurant class.
    // Parameters: name
    // - name: The name of the restaurant.
    public Restaurant(String name) {
        this.name = name;
        dailySales = new ArrayList<>();
    }

    // Method: Adds sales information for a specific day to the restaurant's daily sales.
    // Parameters: salesInfo
    // - salesInfo: The sales information to be added.    
    public void addSalesInformation(SalesInformation salesInfo) {
        getDailySales().add(salesInfo);
    }

        // Method: Displays the sales information for a specific day.
        // Parameters:
        // - day: The day for which the sales information should be displayed.
        // Precondition: The day should be a valid positive integer representing a day with recorded sales.
        // Postcondition: The sales information for the specified day is displayed on the console.
    public void displaySales(int day) {
        if (day <= 0 || day > getDailySales().size()) {
            System.out.println("Invalid day!");
            return;
        }

        SalesInformation salesInfo = getDailySales().get(day - 1);
        // Display the sales information in a formatted table.
        System.out.println("Restaurant: " + getName());
        System.out.println("Day " + day + " Sales");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");
        for (Food food : salesInfo.getSales()) {
            System.out.printf("| %-35s | %8d | $%8.2f |\n", food.getName(), food.getQuantity(), food.getTotalPrice());
        }
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.printf("| Total Sales                         |          | $%8.2f |\n", salesInfo.getTotalSales());
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println();
    }
    
        // Method: Displays the aggregated sales information for a range of days.
        // Parameters:
        // - startDay: The starting day of the range.
        // - endDay: The ending day of the range.
        // Precondition: The startDay and endDay should be valid positive integers representing a valid range of days with recorded sales.
        // Postcondition: The aggregated sales information for the specified range of days is displayed on the console.
    public void displayAggregatedInformation(int startDay, int endDay) {
        if (startDay <= 0 || endDay > dailySales.size() || startDay > endDay) {
            System.out.println("Invalid start or end day!");
            return;
        }

        System.out.println("Restaurant: " + name);
        System.out.println("Aggregated Information (Day " + startDay + " - " + endDay + ")");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        // Calculate total sales and quantity for the selected range
        double totalSales = 0.0;
        int totalCount = 0;
        for (int i = startDay - 1; i < endDay; i++) {
            SalesInformation salesInfo = dailySales.get(i);
            for (Food food : salesInfo.getSales()) {
                totalSales += food.getTotalPrice();
                totalCount += food.getQuantity();
            }
        }

        // Sort the food items by their total price in descending order
        List<Food> allSales = new ArrayList<>();
        for (int i = startDay - 1; i < endDay; i++) {
            allSales.addAll(dailySales.get(i).getSales());
        }
        Collections.sort(allSales, Comparator.comparingDouble(Food::getTotalPrice).reversed());

        // Display the aggregated information
        for (Food food : allSales) {
            System.out.printf("| %-35s | %8d | $%8.2f |\n", food.getName(), food.getQuantity(), food.getTotalPrice());
        }
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.printf("| Total Sales                         |          | $%8.2f |\n", totalSales);
        System.out.printf("| Average Sales                       |          | $%8.2f |\n", totalSales / totalCount);
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println();
    }
    
    public double getMinimumSales() {
        double minimumSales = Double.MAX_VALUE;
        for (SalesInformation salesInfo : dailySales) {
            double totalSales = salesInfo.getTotalSales();
            if (totalSales < minimumSales) {
                minimumSales = totalSales;
            }
        }
        return minimumSales;
    }

    public double getMaximumSales() {
        double maximumSales = Double.MIN_VALUE;
        for (SalesInformation salesInfo : dailySales) {
            double totalSales = salesInfo.getTotalSales();
            if (totalSales > maximumSales) {
                maximumSales = totalSales;
            }
        }
        return maximumSales;
    }

    public void displayTopHighestSales(int k) {
        List<SalesInformation> sortedSales = new ArrayList<>(dailySales);
        sortedSales.sort(Comparator.comparingDouble(SalesInformation::getTotalSales).reversed());

        System.out.println("Restaurant: " + name);
        System.out.println("Top " + k + " Highest Sales");
        System.out.println("+-------------------------------------+--------------+");
        System.out.println("| Day                                 | Total Sales  |");
        System.out.println("+-------------------------------------+--------------+");
        for (int i = 0; i < k && i < sortedSales.size(); i++) {
            SalesInformation salesInfo = sortedSales.get(i);
            System.out.printf("| Day %-4d                            | $%10.2f |\n", i + 1, salesInfo.getTotalSales());
        }
        System.out.println("+-------------------------------------+--------------+");
        System.out.println();
    }

    public void displayTotalAndAverageSales() {
        System.out.println("Restaurant: " + name);
        System.out.println("Total and Average Sales");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        // Calculate total sales and quantity
        double totalSales = 0.0;
        int totalCount = 0;
        for (SalesInformation salesInfo : dailySales) {
            for (Food food : salesInfo.getSales()) {
                totalSales += food.getTotalPrice();
                totalCount += food.getQuantity();
            }
        }

        // Display the aggregated information
        for (SalesInformation salesInfo : dailySales) {
            for (Food food : salesInfo.getSales()) {
                System.out.printf("| %-35s | %8d | $%8.2f |\n", food.getName(), food.getQuantity(), food.getTotalPrice());
            }
        }
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.printf("| Total Sales                         |          | $%8.2f |\n", totalSales);
        System.out.printf("| Average Sales                       |          | $%8.2f |\n", totalSales / totalCount);
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println();
    }
}
