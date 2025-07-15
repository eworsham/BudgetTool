import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create budget for managing categories and expenses
        Budget budget = new Budget();

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

                    // Display categories and their budgets
                    budget.viewCategories(); // Call method to view categories

                    // Display expenses
                    budget.viewExpenses(); // Call method to view expenses

                    break;
                case "2":
                    addExpense(budget, scanner); // Call method to add expense
                    break;
                case "3":
                    createCategory(budget, scanner); // Call method to create category
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
    // This method prints the available options for the user to choose from
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

    // Method to add a new expense to the budget
    // This method prompts the user for expense details and calls the budget's addExpense method
    private static void addExpense(Budget budget, Scanner scanner) {
        Utils.typeLine(("Adding an expense..."));
        Utils.typeText("Enter expense description: ");
        String description = scanner.next();
        Utils.typeText("Enter expense amount: ");
        double amount = scanner.nextDouble();
        Utils.typeText("Enter category name: ");
        String categoryName = scanner.next();
        budget.addExpense(description, amount, categoryName); // Call method to add expense
    }

    // Method to create a new category
    // This method prompts the user for category details and calls the budget's createCategory method
    private static void createCategory(Budget budget, Scanner scanner) {
        Utils.typeLine("Creating a new category...");
        Utils.typeText("Enter category name: ");
        String name = scanner.next();
        Utils.typeText("Enter category budget: ");
        double budgetAmount = scanner.nextDouble();
        budget.createCategory(name, budgetAmount); // Call method to create category
    }
}
