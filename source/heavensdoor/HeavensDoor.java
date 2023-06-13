import java.io.*;
import java.util.*;

public class HeavensDoor {
    public static void run() throws FileNotFoundException {
        String[] residentsFileContent = getFileContent("residents.csv");
        String[] standsFileContent = getFileContent("stands.csv");

        Map<String, String> standUsersByName = getStandUsersByName(standsFileContent);
        Map<String, String[]> userInformation = getUserInformation(residentsFileContent);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            
            System.out.println("======================================================================");
            System.out.print("Enter location (type 'exit' to quit): ");
            String location = scanner.nextLine();

            if (location.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            }

            System.out.println("Resident Information in " + location);
            List<List<String>> originalData = getFilteredStandsFileContent(standsFileContent, getStandAbilitiesByName(standsFileContent),
                    userInformation, standUsersByName, location);

            printStandsFileContent(originalData);

            System.out.println("======================================================================");
            System.out.print("Enter the sorting order : ");
            String sortingOrder = scanner.nextLine();

            System.out.print("Enter sorting type (Ascending, Descending): ");
            String sortingDirection = scanner.nextLine();

            System.out.println();
            List<List<String>> sortedData = new ArrayList<>(originalData);
            sortData(sortedData, sortingOrder, sortingDirection);
            printSortedStandsFileContent(sortedData);

            System.out.println();
        }
    }

    public static String[] getFileContent(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        String header = scanner.nextLine();
        StringBuilder contentBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            contentBuilder.append(scanner.nextLine()).append("\n");
        }
        scanner.close();

        String content = contentBuilder.toString().trim();
        return content.split("\n");
    }

    public static Map<String, String> getStandUsersByName(String[] standsFileContent) {
        Map<String, String> standUsersByName = new HashMap<>();
        for (String line : standsFileContent) {
            String[] columns = line.split(",");
            String standName = columns[0];
            String standUser = columns[1];
            standUsersByName.put(standUser, standName);
        }
        return standUsersByName;
    }

    public static Map<String, String[]> getUserInformation(String[] residentsFileContent) {
        Map<String, String[]> userInformation = new HashMap<>();
        for (String line : residentsFileContent) {
            String[] columns = line.split(",");
            String name = columns[0];
            String[] info = new String[]{columns[1], columns[2], columns[3]};
            userInformation.put(name, info);
        }
        return userInformation;
    }

    public static void printSortedStandsFileContent(List<List<String>> sortedData) {
        System.out.format("+----+-----------------------+-----+--------+--------------------------------+-------------------+------------+------------+------------+-----------+-----------------------+%n");
        System.out.format("| No | Name                  | Age | Gender | Stand                          | Destructive Power |    Speed   |    Range   | Stamina    | Precision | Development Potential |%n");
        System.out.format("+----+-----------------------+-----+--------+--------------------------------+-------------------+------------+------------+------------+-----------+-----------------------+%n");

        int count = 1;
        for (List<String> item : sortedData) {
            System.out.format("| %2s | %-21s | %-3s | %-6s | %-30s | %-17s | %-10s | %-10s | %-10s | %-9s | %-21s |%n",
                    count++, item.get(0), item.get(1), item.get(2), item.get(3), item.get(4), item.get(5),
                    item.get(6), item.get(7), item.get(8), item.get(9));
        }

        System.out.format("+----+-----------------------+-----+--------+--------------------------------+-------------------+------------+------------+------------+-----------+-----------------------+%n");
    }

    public static List<List<String>> getFilteredStandsFileContent(String[] standsFileContent,
                                                                   Map<String, String[]> standAbilitiesByName,
                                                                   Map<String, String[]> userInformation,
                                                                   Map<String, String> standUsersByName,
                                                                   String location) {
        List<List<String>> data = new ArrayList<>();

        for (String line : userInformation.keySet()) {
            String standUser = line;
            String stand = standUsersByName.getOrDefault(standUser, "N/A");
            String[] abilities = standAbilitiesByName.getOrDefault(stand, new String[]{"Null", "Null", "Null", "Null", "Null", "Null"});

            String[] userInfo = userInformation.getOrDefault(standUser, new String[]{"N/A", "N/A", "N/A"});
            if (userInfo[2].equalsIgnoreCase(location)) {
                List<String> item = new ArrayList<>();
                item.add(standUser);
                item.add(userInfo[0]);
                item.add(userInfo[1]);
                item.add(stand);
                item.addAll(Arrays.asList(abilities));
                data.add(item);
            }
        }

        return data;
    }

    public static void printStandsFileContent(List<List<String>> data) {
        System.out.format("+----+-----------------------+-----+--------+--------------------------------+-------------------+------------+------------+------------+-----------+-----------------------+%n");
        System.out.format("| No | Name                  | Age | Gender | Stand                          | Destructive Power |    Speed   |    Range   | Stamina    | Precision | Development Potential |%n");
        System.out.format("+----+-----------------------+-----+--------+--------------------------------+-------------------+------------+------------+------------+-----------+-----------------------+%n");

        int count = 1;
        for (List<String> item : data) {
            System.out.format("| %2s | %-21s | %-3s | %-6s | %-30s | %-17s | %-10s | %-10s | %-10s | %-9s | %-21s |%n",
                    count++, item.get(0), item.get(1), item.get(2), item.get(3), item.get(4), item.get(5),
                    item.get(6), item.get(7), item.get(8), item.get(9));
        }

        System.out.format("+----+-----------------------+-----+--------+--------------------------------+-------------------+------------+------------+------------+-----------+-----------------------+%n");
    }

  public static void sortData(List<List<String>> data, String sortingOrder, String sortingDirection) {
    Comparator<List<String>> comparator;

    switch (sortingOrder.toLowerCase()) {
        case "name":
            comparator = Comparator.comparing(item -> item.get(0), Comparator.nullsLast(Comparator.reverseOrder()));
            break;
        case "age":
            comparator = Comparator.comparing(item -> item.get(1), Comparator.nullsLast(Comparator.reverseOrder()));
            break;
        case "gender":
            comparator = Comparator.comparing(item -> item.get(2), Comparator.nullsLast(Comparator.reverseOrder()));
            break;
        case "stand":
            comparator = Comparator.comparing(item -> item.get(3), Comparator.nullsLast(Comparator.reverseOrder()));
            break;
        case "destructive power":
            comparator = Comparator.comparing(item -> item.get(4), sortDestructivePower());
            break;
        case "speed":
            comparator = Comparator.comparing(item -> item.get(5), sortSpeed());
            break;
        case "range":
            comparator = Comparator.comparing(item -> item.get(6), sortRange());
            break;
        case "stamina":
            comparator = Comparator.comparing(item -> item.get(7), sortStamina());
            break;
        case "precision":
            comparator = Comparator.comparing(item -> item.get(8), sortPrecision());
            break;
        case "development potential":
            comparator = Comparator.comparing(item -> item.get(9), sortDevelopmentPotential());
            break;
        default:
            System.out.println("Invalid sorting order.");
            return;
    }

    if (sortingDirection.equalsIgnoreCase("ascending")) {
        data.sort(comparator.reversed());
    } else {
        data.sort(comparator);
    }
}

    private static Comparator<String> sortDestructivePower() {
        List<String> order = Arrays.asList("Infinity", "A", "B", "C", "D", "E", "?", "Null");
        return Comparator.comparingInt(order::indexOf);
    }

    private static Comparator<String> sortSpeed() {
        List<String> order = Arrays.asList("Infinity", "A", "B", "C", "D", "E", "?", "Null");
        return Comparator.comparingInt(order::indexOf);
    }

    private static Comparator<String> sortRange() {
        List<String> order = Arrays.asList("Infinity", "A", "B", "C", "D", "E", "?", "Null");
        return Comparator.comparingInt(order::indexOf);
    }

    private static Comparator<String> sortStamina() {
        List<String> order = Arrays.asList("Infinity", "A", "B", "C", "D", "E", "?", "Null");
        return Comparator.comparingInt(order::indexOf);
    }

    private static Comparator<String> sortPrecision() {
        List<String> order = Arrays.asList("Infinity", "A", "B", "C", "D", "E", "?", "Null");
        return Comparator.comparingInt(order::indexOf);
    }

    private static Comparator<String> sortDevelopmentPotential() {
        List<String> order = Arrays.asList("Infinity", "A", "B", "C", "D", "E", "?", "Null");
        return Comparator.comparingInt(order::indexOf);
    }

    public static Map<String, String[]> getStandAbilitiesByName(String[] standsFileContent) {
        Map<String, String[]> standAbilitiesByName = new HashMap<>();
        boolean isSeparator = false;
        for (String line : standsFileContent) {
            if (line.equals("-+-----------------------+")) {
                isSeparator = !isSeparator;
            } else if (!isSeparator) {
                String[] columns = line.split(",");
                String stand = columns[0].trim();
                String[] abilities = new String[6];
                for (int i = 0; i < 6; i++) {
                    abilities[i] = columns[i + 2].trim();
                }
                standAbilitiesByName.put(stand, abilities);
            }
        }
        return standAbilitiesByName;
    }
}
