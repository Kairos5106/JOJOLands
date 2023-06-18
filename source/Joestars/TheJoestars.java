package DSTeam3.source.Joestars;

import java.io.*;
import java.util.*;
import DSTeam3.source.Joestars.OrderList;;

public class TheJoestars {
    static int day = 1;
    static String filePath = "DSTeam3\\source\\AssignFood.csv";
    
    static String[][] originalMenuItems = {
            {"Jade Garden", "Braised Chicken in Black Bean Sauce", "15.00"},
            {"Jade Garden", "Braised Goose Web with Vermicelli", "21.00"},
            {"Jade Garden", "Deep-fried Hiroshima Oysters", "17.00"},
            {"Jade Garden", "Poached Tofu with Dried Shrimps", "12.00"},
            {"Jade Garden", "Scrambled Egg White with Milk", "10.00"},
            {"Cafe Deux Magots", "Sampling Matured Cheese Platter", "23.00"},
            {"Cafe Deux Magots", "Spring Lobster Salad", "35.00"},
            {"Cafe Deux Magots", "Spring Organic Omelette", "23.00"},
            {"Cafe Deux Magots", "Truffle-flavoured Poultry Supreme", "34.00"},
            {"Cafe Deux Magots", "White Asparagus", "26.00"},
            {"Trattoria Trussardi", "Caprese Salad", "10.00"},
            {"Trattoria Trussardi", "Creme Caramel", "6.50"},
            {"Trattoria Trussardi", "Lamb Chops with Apple Sauce", "25.00"},
            {"Trattoria Trussardi", "Spaghetti alla Puttanesca", "15.00"},
            {"Libeccio", "Formaggio", "12.50"},
            {"Libeccio", "Ghiaccio", "1.01"},
            {"Libeccio", "Melone", "5.20"},
            {"Libeccio", "Prosciutto and Pesci", "20.23"},
            {"Libeccio", "Risotto", "13.14"},
            {"Libeccio", "Zucchero and Sale", "0.60"},
            {"Savage Garden", "Abbacchio\'s Tea", "1.00"},
            {"Savage Garden", "DIO\'s Bread", "36.14"},
            {"Savage Garden", "Giorno\'s Donuts", "6.66"},
            {"Savage Garden", "Joseph\'s Tequila", "35.00"},
            {"Savage Garden", "Kakyoin\'s Cherry", "3.50"},
            {"Savage Garden", "Kakyoin\'s Porridge", "4.44"}};

    static List<String[]> currentMenuItems = new ArrayList<>();

    static String[] residents = {
            "Erina Pendleton,70,Female",
            "George Joestar II,32,Male",
            "Giorno Giovanna,15,Male",
            "Holy Kujo,45,Female",
            "Jolyne Cujoh,19,Female",
            "Jonathan Joestar,20,Male",
            "Joseph Joestar,18,Male",
            "Josuke Higashikata,16,Male",
            "Jotaro Kujo,17,Male",
            "Lisa Lisa,50,Female",
            "Suzi Q.,N/A,Female",
            "Tomoko Higashikata,37,Female",
            "Iggy,N/A,Male",
            "Jean Pierre Polnareff,24,Male",
            "Muhammad Avdol,29,Male",
            "Noriaki Kakyoin,17,Male",
            "DIO,121,Male",
            "Donatello Versus,25,Male",
            "Enrico Pucci,39,Male",
            "Enya the Hag,N/A,Female",
            "Rikiel,24,Male",
            "Ungalo,24,Male",
            "Vanilla Ice,N/A,Male",
            "Aya Tsuji,N/A,Female",
            "Hayato Kawajiri,11,Male",
            "Koichi Hirose,15,Male",
            "Mikitaka Hazekura,216,Male",
            "Okuyasu Nijimura,15,Male",
            "Reimi Sugimoto,16,Female",
            "Rohan Kishibe,20,Male",
            "Shigekiyo Yangu,14,Male",
            "Tamami Kobayashi,20,Male",
            "Tonio Trussardi,29,Male",
            "Toshikazu Hazamada,18,Male",
            "Yukako Yamagishi,N/A,Female",
            "Yuya Fungami,N/A,Male",
            "Akira Otoishi,19,Male",
            "Anjuro Katagiri,34,Male",
            "Keicho Nijimura,18,Male",
            "Ken Oyanagi,11,Male",
            "Masazo Kinoto,29,Male",
            "Terunosuke Miyamoto,N/A,Male",
            "Toyohiro Kanedaichi,N/A,Male",
            "Yoshihiro Kira,N/A,Male",
            "Yoshikage Kira,33,Male",
            "Bruno Bucciarati,20,Male",
            "Guido Mista,18,Male",
            "Leone Abbacchio,21,Male",
            "Narancia Ghirga,17,Male",
            "Pannacotta Fugo,16,Male",
            "Trish Una,15,Female",
            "Carne,N/A,Male",
            "Cioccolata,34,Male",
            "Diavolo,33,Male",
            "Formaggio,N/A,Male",
            "Ghiaccio,N/A,Male",
            "Illuso,N/A,Male",
            "Mario Zucchero,24,Male",
            "Melone,N/A,Male",
            "Pesci,N/A,Male",
            "Prosciutto,N/A,Male",
            "Risotto Nero,28,Male",
            "Sale,N/A,Male",
            "Secco,N/A,Male",
            "Squalo,N/A,Male",
            "Tizzano,N/A,Male",
            "Emporio Alnino,11,Male",
            "Ermes Costello,21,Female",
            "Foo Fighters,22,Female",
            "Narciso Anasui,25,Male",
            "Weather Report,39,Male"};

    public TheJoestars(){
        currentMenuItems = Arrays.asList(originalMenuItems);
    }

    public static void main(String[] args) {

    }

    public static List<String[]> getFoodMenu(){
        return currentMenuItems;
    }

    public static int getCurrentMenuSize(){
        return currentMenuItems.size();
    }

    public static void setDay(int dayNo){
        day = dayNo;
    }

    public static String getFilePath(){
        return filePath;
    }

    /* Purpose: Creates a .csv file called AssignFood that stores information regarding resident food assignment */
    public static void assignFoodToResidents(){
        boolean append = false;
        if(day != 1){
            append = true;
        }
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(filePath, append));
            if(!append){
                writer.println("Day,Name,Age,Gender,Location,MenuItem,Price,Time"); // Header
            }

            Random random = new Random();
            List<String> assignedResidents = new ArrayList<>(Arrays.asList(residents));
            List<String[]> shuffledMenuItems = getFoodMenu();
            Collections.shuffle(shuffledMenuItems);

            for (int i = 0; i < assignedResidents.size(); i++) {
                String resident = assignedResidents.get(i);
                String[] residentInfo = resident.split(",");
                String name = residentInfo[0];
                String age = residentInfo[1];
                String gender = residentInfo[2];

                String[] menuItem;

                switch (name) {
                    case "Jonathan Joestar":
                        menuItem = shuffledMenuItems.get(i % shuffledMenuItems.size());
                        OrderList jonathan = new OrderList(name, menuItem[1], Double.parseDouble(menuItem[2]));
                        // Retrieve the past order list of jonathan
                        List<OrderList> pastOrders = OrderList.getOrdersByMenuItem(currentMenuItems, jonathan.getFood());
                        // Create a frequency map to track the occurrence of each food item
                        Map<String, Integer> frequencyMap = new HashMap<>();
                        // Update the frequency map based on past orders of Jonathan Joestar
                        for (OrderList order : pastOrders) {
                            String food = order.getFood();
                            frequencyMap.put(food, frequencyMap.getOrDefault(food, 0) + 1);
                        }

                        String mostFrequentFood = null;
                        String leastFrequentFood = null;
                        int maxFrequency = 0;
                        int minFrequency = Integer.MAX_VALUE;

                        // Determine the most and least frequent food items
                        for (String food : frequencyMap.keySet()) {
                            int frequency = frequencyMap.get(food);
                            if (frequency > maxFrequency) {
                                maxFrequency = frequency;
                                mostFrequentFood = food;
                            }
                            if (frequency < minFrequency) {
                                minFrequency = frequency;
                                leastFrequentFood = food;
                            }
                        }

                        // Ensure the difference in frequency between the most and least frequent food is not greater than 1
                        if (maxFrequency - minFrequency > 1) {
                            // Swap the most and least frequent food with their neighboring items in the menu
                            int mostIndex = findFoodIndex(shuffledMenuItems, mostFrequentFood);
                            int leastIndex = findFoodIndex(shuffledMenuItems, leastFrequentFood);
                            int neighborIndex = (mostIndex < leastIndex) ? mostIndex + 1 : mostIndex - 1;

                            String[] mostFrequentItem = shuffledMenuItems.get(mostIndex);
                            String[] leastFrequentItem = shuffledMenuItems.get(leastIndex);
                            String[] neighborItem = shuffledMenuItems.get(neighborIndex);

                            shuffledMenuItems.set(mostIndex, leastFrequentItem);
                            shuffledMenuItems.set(leastIndex, mostFrequentItem);
                            shuffledMenuItems.set(neighborIndex, neighborItem);
                        }

                        menuItem = shuffledMenuItems.get(0);
                        break;
                    case "Joseph Joestar":
                        menuItem = shuffledMenuItems.get(i % shuffledMenuItems.size());

                        break;
                    case "Jotaro Kujo":
                        menuItem = shuffledMenuItems.get(i % shuffledMenuItems.size());

                        break;
                    case "Josuke Higashikata":
                        menuItem = shuffledMenuItems.get(i % shuffledMenuItems.size());

                        break;
                    case "Giorno Giovanna":
                        menuItem = shuffledMenuItems.get(i % shuffledMenuItems.size());

                        break;
                    case "Jolyne Cujoh":
                        menuItem = shuffledMenuItems.get(i % shuffledMenuItems.size());

                        break;
                    default:
                        menuItem = shuffledMenuItems.get(i % shuffledMenuItems.size());
                        break;
                }

                // Generate a random time anywhere including and in between 0 minutes and 60 minutes
                // Because restaurants only open for an hour a day
                int minutes = random.nextInt(61);
                String time = String.format("%02d", minutes);

                // Write the resident information along with menu item details and time
                writer.println(Integer.toString(day) + "," + name + "," + age + "," + gender + "," + menuItem[0] + "," + menuItem[1] + "," + menuItem[2] + "," + time);
            }

            writer.close();
            // System.out.println("New CSV file created successfully."); // debug
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to find the index of a food item in the shuffled menu items list
    private static int findFoodIndex(List<String[]> shuffledMenuItems, String foodName) {
        for (int i = 0; i < shuffledMenuItems.size(); i++) {
            if (shuffledMenuItems.get(i)[1].equals(foodName)) {
                return i;
            }
        }
        return -1;
    }

    public static void displayOrderHistory(String npcName){
        System.out.println("Order History");
        System.out.format("+-----+-------------------------------------------+------------------------------------+%n");
        System.out.format("| Day | Food                                      | Restaurant                         |%n");
        System.out.format("+-----+-------------------------------------------+------------------------------------+%n");

        try{
            Scanner in = new Scanner(new FileInputStream(filePath));
            String[] row;
            String line;
            while(in.hasNextLine()){
                line = in.nextLine();
                row = line.split(","); // 0 = day, 1 = name, restaurant = 4, food name = 5
                if(npcName.equalsIgnoreCase(row[1])){
                    System.out.printf("|  %2s | %-41s | %-34s |\n", row[0], row[5], row[4]); // numbers add up to 77 to align table properly
                }
            }
            System.out.format("+-----+-------------------------------------------+------------------------------------+%n%n");
            in.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /* =================================== THE 6 JOESTARS FOOD ASSIGNMENT METHODS =================================== */

   


    /* =============================================================================================================== */

}


