import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create scanner for user input

        // Display welcome message with typing effect
        System.out.println(); // Add spacing
        Utils.typeLine("Welcome to the Budget Tool!");
        Utils.typeLine("This tool helps you manage your budget effectively.");

        // While loop for the main menu of the budget tool
        // This loop will continue until the user chooses to exit
        while (true) {
            // Display menu options
            displayMenu();

            // Get user input
            String choice = scanner.next();

            // Handle user input
            switch (choice) {
                case "1":
                    Utils.typeLine("Viewing budget...");
                    break;
                case "2":
                    Utils.typeLine("Adding expense...");
                    break;
                case "3":
                    Utils.typeLine("Creating category...");
                    break;
                case "4":
                    Utils.typeLine("Exiting...");
                    scanner.close(); // Close scanner before exiting
                    return; // Exit the program
                default:
                    Utils.typeLine("Invalid option. Please try again.");
            }
        }
    }

    // Method to display main menu options
    private static void displayMenu() {
        System.out.println(); // Add spacing
        Utils.typeLine("Menu Options:");
        Utils.typeLine("1. View Budget");
        Utils.typeLine("2. Add Expense");
        Utils.typeLine("3. Create Category");
        Utils.typeLine("4. Exit");
        System.out.println(); // Add spacing
        Utils.typeText("Please choose an option: ");
    }
}
