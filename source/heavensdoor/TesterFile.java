import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesterHeavensDoor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("[1] View Resident Information");
            System.out.println("[2] Exit");
            System.out.print("Select: ");
           
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    HeavensDoor heavensDoor = new HeavensDoor();
                    try {
                        heavensDoor.run();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        
        scanner.close();
    }
}
