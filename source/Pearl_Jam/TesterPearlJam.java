package source.Pearl_Jam;

import source.Pearl_Jam.JadeGarden;
import source.Pearl_Jam.JadeGardenMenu;
import source.Pearl_Jam.Customer;
import source.Pearl_Jam.Restaurant;
import java.util.Scanner;

// Test jade garden
public class TesterPearlJam {
    public static void main(String[] args) {
        JadeGarden jadeGarden = new JadeGarden();
        JadeGardenMenu jadeGardenMenu = new JadeGardenMenu();

        jadeGarden.addCustomerToWaitingList(new Customer("Jonathan Joestar", 20, "Male"));
        jadeGarden.addCustomerToWaitingList(new Customer("Joseph Joestar", 18, "Male"));
        jadeGarden.addCustomerToWaitingList(new Customer("Jotaro Kujo", 17, "Male"));
        jadeGarden.addCustomerToWaitingList(new Customer("Josuke Higashikata", 16, "Male"));
        jadeGarden.addCustomerToWaitingList(new Customer("Giorno Giovanna", 15, "Male"));
        jadeGarden.addCustomerToWaitingList(new Customer("Jolyne Cujoh", 19, "Female"));

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
