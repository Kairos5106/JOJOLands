package DSTeam3.source.Joestars;

import java.io.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AssignFood {
    public static void main(String[] args) {
       String[][] menuItems = {
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
                {"Trattoria Trussardi", "Creme caramel", "6.50"},
                {"Trattoria Trussardi", "Lamb Chops with Apple Sauce", "25.00"}, // stopped here
                {"Trattoria Trussardi", "Spaghetti alla Puttanesca", "15.00"},
                {"Libeccio", "Formaggio", "12.50"},
                {"Libeccio", "Ghiaccio", "1.01"},
                {"Libeccio", "Melone", "5.20"},
                {"Libeccio", "Prosciutto and Pesci", "20.23"},
                {"Libeccio", "Risotto", "13.14"},
                {"Libeccio", "Zucchero and Sale", "0.60"},
                {"Savage Garden", "Abbacchio’s Tea", "1.00"},
                {"Savage Garden", "DIO’s Bread", "36.14"},
                {"Savage Garden", "Giorno’s Donuts", "6.66"},
                {"Savage Garden", "Joseph’s Tequila", "35.00"},
                {"Savage Garden", "Kakyoin’s Cherry", "3.50"},
                {"Savage Garden", "Kakyoin’s Porridge", "4.44"}
};

        String[] residents = {
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
                "Weather Report,39,Male"
};

        String filePath = "DSTeam3\\source\\AssignFood.csv";

         try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8));
            writer.write("Name,Age,Gender,Location,MenuItem,Price,Time\n"); // Header

            Random random = new Random();
            List<String> assignedResidents = new ArrayList<>(Arrays.asList(residents));
            List<String[]> shuffledMenuItems = new ArrayList<>(Arrays.asList(menuItems));
            Collections.shuffle(shuffledMenuItems);

            for (int i = 0; i < assignedResidents.size(); i++) {
                String resident = assignedResidents.get(i);
                String[] residentInfo = resident.split(",");
                String name = residentInfo[0];
                String age = residentInfo[1];
                String gender = residentInfo[2];

                String[] menuItem = shuffledMenuItems.get(i % shuffledMenuItems.size());

                // Generate a random time between 00:00 and 23:59
                int hours = random.nextInt(24); // 0-23
                int minutes = random.nextInt(60);
                String time = String.format("%02d:%02d", hours, minutes);

                // Write the resident information along with menu item details and time
                writer.write(name + "," + age + "," + gender + "," + menuItem[0] + "," + menuItem[1] + "," + menuItem[2] + "," + time + "\n");
            }

            writer.close();
            System.out.println("New CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
     
    }
}
