/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.MoodyBlues;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author firza
 */
public class MoodyBluesTester  {
   
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Jade Garden");

        // Read data from the CSV file
        String csvFile = "DSTeam3\\source\\AssignFood.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                // Assuming the CSV file columns are: Day, Location, Menu Item, Price
                int day = Integer.parseInt(data[0]);
                String location = data[4];
                String menuItem = data[5];
                double price = Double.parseDouble(data[6]);

                // Filter the data based on location and desired columns
                if (location.equals("Jade Garden")) {
                    SalesInformation salesInfo;
                    if (day > restaurant.getDailySales().size()) {
                        salesInfo = new SalesInformation();
                        restaurant.addSalesInformation(salesInfo);
                    } else {
                        salesInfo = restaurant.getDailySales().get(day - 1);
                    }

                    Food food = new Food(menuItem, 1, price); // Set quantity as 1 for each food
                    salesInfo.addSale(food);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Restaurant: " + restaurant.getName());
            System.out.println("Sales Information");
            System.out.println("[1] View Sales");
            System.out.println("[2] View Aggregated Information");
            System.out.println("[3] Exit");
            System.out.print("Select: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Day: ");
                    int day = scanner.nextInt();
                    restaurant.displaySales(day);
                    break;
                case 2:
                    System.out.println("Aggregated Information");
                    System.out.println("[A] Minimum Sales");
                    System.out.println("[B] Maximum Sales");
                    System.out.println("[C] Top k Highest Sales");
                    System.out.println("[D] Total and Average Sales");
                    System.out.print("Select option: ");
                    String subOption = scanner.next();
                    switch (subOption) {
                        case "A":
                            double minimumSales = restaurant.getMinimumSales();
                            System.out.println("Minimum Sales: $" + minimumSales);
                            break;
                        case "B":
                            double maximumSales = restaurant.getMaximumSales();
                            System.out.println("Maximum Sales: $" + maximumSales);
                            break;
                        case "C":
                            System.out.print("Enter value of k: ");
                            int k = scanner.nextInt();
                            restaurant.displayTopHighestSales(k);
                            break;
                        case "D":
                            restaurant.displayTotalAndAverageSales();
                            break;
                        default:
                            System.out.println("Invalid sub-option!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 3);
    }
}



