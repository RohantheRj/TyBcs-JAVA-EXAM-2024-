import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CitySTDCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cityCodes = new HashMap<>();

        while (true) {
            System.out.println("\n1. Add a city and its STD code");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city's STD code");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCity(cityCodes, scanner);
                    break;
                case 2:
                    removeCity(cityCodes, scanner);
                    break;
                case 3:
                    searchCity(cityCodes, scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addCity(Map<String, Integer> cityCodes, Scanner scanner) {
        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();

        if (cityCodes.containsKey(cityName)) {
            System.out.println("City already exists in the list.");
        } else {
            System.out.print("Enter STD code for " + cityName + ": ");
            int stdCode = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            cityCodes.put(cityName, stdCode);
            System.out.println(cityName + " added with STD code " + stdCode);
        }
    }

    private static void removeCity(Map<String, Integer> cityCodes, Scanner scanner) {
        System.out.print("Enter city name to remove: ");
        String cityName = scanner.nextLine();

        if (cityCodes.containsKey(cityName)) {
            cityCodes.remove(cityName);
            System.out.println(cityName + " removed from the list.");
        } else {
            System.out.println("City not found in the list.");
        }
    }

    private static void searchCity(Map<String, Integer> cityCodes, Scanner scanner) {
        System.out.print("Enter city name to search: ");
        String cityName = scanner.nextLine();

        if (cityCodes.containsKey(cityName)) {
            int stdCode = cityCodes.get(cityName);
            System.out.println("STD code for " + cityName + " is " + stdCode);
        } else {
            System.out.println("City not found in the list.");
        }
    }
}

