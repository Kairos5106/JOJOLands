package source.PearlJam;

import java.util.Date;
import java.util.Scanner;

import source.PearlJam.Customer;
import source.PearlJam.JadeGarden;
import source.PearlJam.JadeGardenMenu;
import source.PearlJam.Restaurant;

// Test Jade Garden
public class TesterPearlJam {
    public static void main(String[] args) {
        JadeGarden jadeGarden = new JadeGarden();
        JadeGardenMenu jadeGardenMenu = new JadeGardenMenu();

        jadeGarden.addCustomerToWaitingList(new Customer("Jonathan Joestar", 20, "Male", "Braised Chicken in Black Bean Sauce", new Date()));
        jadeGarden.addCustomerToWaitingList(new Customer("Joseph Joestar", 18, "Male", "Scrambled Egg White with Milk", new Date()));
        jadeGarden.addCustomerToWaitingList(new Customer("Jotaro Kujo", 17, "Male", "Braised Goose Web with Vermicelli", new Date()));
        jadeGarden.addCustomerToWaitingList(new Customer("Josuke Higashikata", 16, "Male", "Poached Tofu with Dried Shrimps", new Date()));
        jadeGarden.addCustomerToWaitingList(new Customer("Giorno Giovanna", 15, "Male", "Deep-fried Hiroshima Oysters", new Date()));
        jadeGarden.addCustomerToWaitingList(new Customer("Jolyne Cujoh", 19, "Female", "Braised Goose Web with Vermicelli", new Date()));

        jadeGarden.processOrders();

        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            jadeGardenMenu.runDisplay();
            String input = scanner.nextLine().trim();
            jadeGardenMenu.execute(input);

            if (jadeGardenMenu.isExitInterface()) {
                exitProgram = true;
            }
        }
    }
}
