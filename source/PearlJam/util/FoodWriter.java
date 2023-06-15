package DSTeam3.source.PearlJam.util;

import java.io.*;

public class FoodWriter {    
    public FoodWriter(){}

    public static void main(String[] args) {
        writeFile();
    }

    public static void writeFile(){
        String filePath = "DSTeam3\\source\\foodmenu.txt";
            try {
                PrintWriter writer = new PrintWriter(new FileOutputStream(filePath));
                // Write the data rows
                writer.write("Jade Garden,Braised Chicken in Black Bean Sauce,15.00\n");
                writer.write("Jade Garden,Braised Goose Web with Vermicelli,21.00\n");
                writer.write("Jade Garden,Deep-fried Hiroshima Oysters,17.00\n");
                writer.write("Jade Garden,Poached Tofu with Dried Shrimps,2.00\n");
                writer.write("Jade Garden,Scrambled Egg White with Milk,10.00\n");
                writer.write("Cafe Deux Magots,Sampling Matured Cheese Platter,23.00\n");
                writer.write("Cafe Deux Magots,Sampling Matured Cheese Platter,23.00\n");
                writer.write("Cafe Deux Magots,Spring Lobster Salad,35.00\n");
                writer.write("Cafe Deux Magots,Spring Organic Omelette,23.00\n");
                writer.write("Cafe Deux Magots,Truffle-flavoured Poultry Supreme,34.00\n");
                writer.write("Cafe Deux Magots,White Asparagus,26.00\n");
                writer.write("Trattoria Trussardi,Caprese Salad,10.00\n");
                writer.write("Trattoria Trussardi,Creme caramel,6.50\n");
                writer.write("Trattoria Trussardi,Lamb Chops with Apple Sauce,25.00\n");
                writer.write("Trattoria Trussardi,Spaghetti alla Puttanesca,15.00\n");
                writer.write("Libeccio,Formaggio,12.50\n");
                writer.write("Libeccio,Ghiaccio,1.01\n");
                writer.write("Libeccio,Melone,5.20\n");
                writer.write("Libeccio,Prosciutto and Pesci,20.23\n");
                writer.write("Libeccio,Risotto,13.14\n");
                writer.write("Libeccio,Zucchero and Sale,0.60\n");
                writer.write("Savage Garden,Abbacchio’s Tea,1.00\n");
                writer.write("Savage Garden,DIO’s Bread,36.14\n");
                writer.write("Savage Garden,Giorno’s Donuts,6.66\n");
                writer.write("Savage Garden,Joseph’s Tequila,35.00\n");
                writer.write("Savage Garden,Kakyoin’s Cherry,3.50\n");
                writer.write("Savage Garden,Kakyoin’s Porridge,4.44\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
