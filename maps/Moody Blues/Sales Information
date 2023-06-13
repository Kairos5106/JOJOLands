import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SalesInformation {
    private Restaurant restaurant;

    public SalesInformation(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // Main function: Display sales information for a specific day
    public void viewSalesByDay(Date day) {
        // Preprocessing: Retrieve sales data and create a DecimalFormat object
        List<Customer> salesData = restaurant.getWaitingList();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        
        System.out.println("Restaurant: " + restaurant.getNameRestaurant());
        System.out.println("Day " + day + " Sales");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        double totalSales = 0;

        for (Customer customer : salesData) {
            // Preprocessing: Check if the customer arrived on the specified day
            if (isSameDay(customer.getArrivalTime(), day)) {
                String[] order = customer.getOrder().split(":");
                String food = order[0];
                int quantity = Integer.parseInt(order[1]);
                double price = restaurant.getMenu().contains(food) ? quantity * getPrice(food) : 0;
                totalSales += price;

                System.out.printf("| %-35s | %-8d | $%-10s |%n", food, quantity, decimalFormat.format(price));
            }
        }
        // Postprocessing: Display the total sales for the specified day
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.printf("| Total Sales                         | %-8s | $%-10s |%n", "", decimalFormat.format(totalSales));
        System.out.println("+-------------------------------------+----------+-------------+");
    }
    
    // Main function: Display the food item with the minimum sales within a specified date range
    public void viewMinimumSales(Date startDate, Date endDate) {
        // Preprocessing: Retrieve sales data within the specified date range and create a DecimalFormat object
        List<Customer> salesData = getSalesDataInRange(startDate, endDate);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println("Restaurant: " + restaurant.getNameRestaurant());
        System.out.println("Minimum Sales (Day " + startDate + " - " + endDate + ")");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        Map<String, Double> foodSales = calculateFoodSales(salesData);
        Optional<Map.Entry<String, Double>> minSale = foodSales.entrySet().stream().min(Map.Entry.comparingByValue());
        
        // Preprocessing: Find the food item with the minimum sales
        if (minSale.isPresent()) {
            Map.Entry<String, Double> entry = minSale.get();
            System.out.printf("| %-35s | %-8s | $%-10s |%n", entry.getKey(), "", decimalFormat.format(entry.getValue()));
        }
        // Postprocessing: Display the food item with the minimum sales
        System.out.println("+-------------------------------------+----------+-------------+");
    }

    // Main function: Display the food item with the maximum sales within a specified date range
    public void viewMaximumSales(Date startDate, Date endDate) {
        // Preprocessing: Retrieve sales data within the specified date range and create a DecimalFormat object
        List<Customer> salesData = getSalesDataInRange(startDate, endDate);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println("Restaurant: " + restaurant.getNameRestaurant());
        System.out.println("Maximum Sales (Day " + startDate + " - " + endDate + ")");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        Map<String, Double> foodSales = calculateFoodSales(salesData);
        Optional<Map.Entry<String, Double>> maxSale = foodSales.entrySet().stream().max(Map.Entry.comparingByValue());

        // Preprocessing: Find the food item with the maximum sales
        if (maxSale.isPresent()) {
            Map.Entry<String, Double> entry = maxSale.get();
            System.out.printf("| %-35s | %-8s | $%-10s |%n", entry.getKey(), "", decimalFormat.format(entry.getValue()));
        }
        // Postprocessing: Display the food item with the maximum sales
        System.out.println("+-------------------------------------+----------+-------------+");
    }

    // Main function: Display the top K food items with the highest sales within a specified date range
    public void viewTopKHighestSales(Date startDate, Date endDate, int k) {
        // Preprocessing: Retrieve sales data within the specified date range and create a DecimalFormat object
        List<Customer> salesData = getSalesDataInRange(startDate, endDate);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println("Restaurant: " + restaurant.getNameRestaurant());
        System.out.println("Top " + k + " Highest Sales (Day " + startDate + " - " + endDate + ")");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        // Preprocessing: Sort the food items by sales in descending order and limit the list to top K items
        Map<String, Double> foodSales = calculateFoodSales(salesData);
        List<Map.Entry<String, Double>> sortedSales = foodSales.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .collect(Collectors.toList());

         // Postprocessing: Display the top K food items with the highest sales
        for (Map.Entry<String, Double> entry : sortedSales) {
            System.out.printf("| %-35s | %-8s | $%-10s |%n", entry.getKey(), "", decimalFormat.format(entry.getValue()));
        }

        System.out.println("+-------------------------------------+----------+-------------+");
    }

    // Main function: Display the total and average sales within a specified date range
    public void viewTotalAndAverageSales(Date startDate, Date endDate) {
        // Preprocessing: Retrieve sales data within the specified date range and create a DecimalFormat object
        List<Customer> salesData = getSalesDataInRange(startDate, endDate);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println("Restaurant: " + restaurant.getNameRestaurant());
        System.out.println("Total and Average Sales (Day " + startDate + " - " + endDate + ")");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        // Preprocessing: Calculate the total and average sales
        Map<String, Double> foodSales = calculateFoodSales(salesData);
        double totalSales = foodSales.values().stream().mapToDouble(Double::doubleValue).sum();
        double averageSales = totalSales / salesData.size();

        for (Map.Entry<String, Double> entry : foodSales.entrySet()) {
            System.out.printf("| %-35s | %-8s | $%-10s |%n", entry.getKey(), "", decimalFormat.format(entry.getValue()));
        }

        // Postprocessing: Display the food items with their respective sales, total sales, and average sales
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.printf("| Total Sales                         | %-8s | $%-10s |%n", "", decimalFormat.format(totalSales));
        System.out.printf("| Average Sales                       | %-8s | $%-10s |%n", "", decimalFormat.format(averageSales));
        System.out.println("+-------------------------------------+----------+-------------+");
    }

    private List<Customer> getSalesDataInRange(Date startDate, Date endDate) {
        List<Customer> salesData = restaurant.getWaitingList();
        List<Customer> filteredSalesData = new ArrayList<>();

        for (Customer customer : salesData) {
            Date arrivalTime = customer.getArrivalTime();
            if (isSameDay(arrivalTime, startDate) || (arrivalTime.after(startDate) && arrivalTime.before(endDate))) {
                filteredSalesData.add(customer);
            }
        }

        return filteredSalesData;
    }

    private Map<String, Double> calculateFoodSales(List<Customer> salesData) {
    // Main function: Calculate the sales for each food item based on the given sales data

    Map<String, Double> foodSales = new HashMap<>();

    for (Customer customer : salesData) {
        String[] order = customer.getOrder().split(":");
        String food = order[0];
        int quantity = Integer.parseInt(order[1]);
        double price = restaurant.getMenu().contains(food) ? quantity * getPrice(food) : 0;
        foodSales.put(food, foodSales.getOrDefault(food, 0.0) + price);
    }

    // Postprocessing: Calculate the sales for each food item and store them in a map

    return foodSales;
    }


    private double getPrice(String food) {
    // Main function: Retrieve the price of the given food item

    // This method should be implemented based on your actual implementation or data source
    // It should return the price of the given food item

    return 0.0;
    }


    private boolean isSameDay(Date date1, Date date2) {
    // Main function: Compare two dates to check if they are the same day

    // This method should be implemented based on your actual implementation or library used for date comparison
    // It should return true if the two dates are the same day, otherwise false

    return false;
}

}
