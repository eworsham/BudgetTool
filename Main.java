import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Display welcome message with typing effect
        System.out.println(); // Add spacing
        Utils.typeLine("Welcome to the Budget Tool!");
        Utils.typeLine("This tool helps you manage your budget effectively.");

        // Load budget data from file if it exists, otherwise create a new budget
        // Create budget for managing categories and expenses
        Budget budget = loadBudgetData();

        Scanner scanner = new Scanner(System.in); // Create scanner for user input

        // While loop for the main menu of the budget tool
        // This loop will continue until the user chooses to exit
        while (true) {
            // Display menu options
            displayMenu();

            // Get user input
            String choice = scanner.nextLine();

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
                    increaseCategoryBudget(budget, scanner); // Call method to increase category budget
                    break;
                case "5":
                    saveBudgetData(budget); // Call method to save budget data to file
                    Utils.typeLine("Thank you for using the Budget Tool!");
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
        Utils.typeLine("4. Increase Category Budget");
        Utils.typeLine("5. Exit");
        System.out.println(); // Add spacing
        Utils.typeText("Please choose an option: ");
    }

    // Method to add a new expense to the budget
    // This method prompts the user for expense details and calls the budget's addExpense method
    private static void addExpense(Budget budget, Scanner scanner) {
        Utils.typeLine(("Adding an expense..."));
        Utils.typeText("Enter expense description: ");
        String description = scanner.nextLine();
        Utils.typeText("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline character
        Utils.typeText("Enter category name: ");
        String categoryName = scanner.nextLine();
        budget.addExpense(description, amount, categoryName); // Call method to add expense
    }

    // Method to create a new category
    // This method prompts the user for category details and calls the budget's createCategory method
    private static void createCategory(Budget budget, Scanner scanner) {
        Utils.typeLine("Creating a new category...");
        Utils.typeText("Enter category name: ");
        String name = scanner.nextLine();
        Utils.typeText("Enter category budget: ");
        double budgetAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline character
        budget.createCategory(name, budgetAmount); // Call method to create category
    }

    // Method to increase the budget of an existing category
    private static void increaseCategoryBudget(Budget budget, Scanner scanner) {
        Utils.typeLine("Increasing category budget...");
        Utils.typeText("Enter category name: ");
        String categoryName = scanner.nextLine();
        Utils.typeText("Enter amount to increase budget by: ");
        double increaseAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline character
        budget.increaseCategoryBudget(categoryName, increaseAmount); // Call method to increase category budget
    }

    // Method to save budget data to file name "budget_data.txt"
    private static void saveBudgetData(Budget budget) {
        Utils.writeToFile("budget_data.txt", budget.toString()); // Call method to write budget data to file
        Utils.typeLine("Budget data saved to budget_data.txt");
    }

    // Method to load budget data from file "budget_data.txt"
    private static Budget loadBudgetData() {
        // Check if the file exists and read data from it
        File file = new File("budget_data.txt");
        if (!file.exists()) {
            Utils.typeLine("No existing budget data found. Starting with a new budget.");
            return new Budget(); // Return a new budget if file does not exist
        }
        
        // Read data from the file and create a Budget object
        String data = Utils.readFromFile("budget_data.txt");
        return Budget.fromString(data);
    }

}
