import java.util.ArrayList;
import java.util.List;

// Budget class to manage categories and expenses
// This class contains methods to create categories, add expenses, and view category balances
public class Budget {
    private List<Category> categories;
    private List<Expense> expenses;

    // Constructor to initialize the budget with empty lists for categories and expenses
    public Budget() {
        categories = new ArrayList<>();
        expenses = new ArrayList<>();
    }

    // Method to return the number of categories
    public int getCategoryCount() {
        return categories.size();
    }

    // Method to create a new category given a name and budget
    public void createCategory(String name, double budget) {
        Category category = new Category(name, budget);
        categories.add(category);
        Utils.typeLine("Category created: " + name + " with budget $" + budget);
    }

    // Method to increase the budget of an existing category
    public void increaseCategoryBudget(String categoryName, double amount) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                category.setBudget(category.getBudget() + amount);
                Utils.typeLine("Increased budget for category: " + category.getName() + " by $" + amount);
                return;
            }
        }
        Utils.typeLine("Category not found: " + categoryName);
    }

    // Method to add an expense given a description, amount, and a category
    public void addExpense(String description, double amount, String categoryName) {
        Category targetCategory = null;

        // Serach for existing category
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                targetCategory = category;
                break;
            }
        }

        // If category doesn't exist, create it
        if (targetCategory == null) {
            targetCategory = new Category(categoryName, 0);
            categories.add(targetCategory);
            Utils.typeLine("Category " + categoryName + " does not exist. Created with budget $0.");
        }

        // Subtract the expense amount from the category budget
        double newBudget = targetCategory.getBudget() - amount;
        targetCategory.setBudget(newBudget);

        // Add expense to the budget
        Expense expense = new Expense(description, amount, categoryName);
        expenses.add(expense);
        Utils.typeLine("Expense added: " + description + " for $" + amount + " in category " + categoryName);
    }

    // Methods to view category balances
    public void viewCategories() {
        if (categories.isEmpty()) {
            Utils.typeLine("No categories available.");
        } else {
            Utils.typeLine("Categories:");
            for (Category category : categories) {
                category.displayCategory();
            }
        }
    }

    // Method to view all expenses
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            Utils.typeLine("No expenses available.");
        } else {
            Utils.typeLine("Viewing expenses...");
            for (Expense expense : expenses) {
                expense.displayExpense();
            }
        }
    }

    // Method to return a string representation of the budget for saving to a file
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : categories) {
            stringBuilder.append(category.toString()).append("\n");
        }
        for (Expense expense : expenses) {
            stringBuilder.append(expense.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    // Method to create a Budget object from a string representation
    public static Budget fromString(String data) {
        Budget budget = new Budget();

        // Split the data into lines and parse categories and expenses
        String[] lines = data.split("\n");
        Category category = null;

        // Iterate through each line to parse categories and expenses
        for (String line : lines) {
            if (line.trim().isEmpty())
                continue; // Skip empty lines

            if (line.startsWith("Category:")) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0].substring("Category:".length()); // Remove the "Category:" prefix
                    double budgetAmount = Double.parseDouble(parts[1]);
                    category = new Category(name, budgetAmount);
                    budget.categories.add(category);
                }
            } else if (line.startsWith("Expense:")) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String description = parts[0].substring("Expense:".length()); // Remove the "Expense:" prefix
                    double amount = Double.parseDouble(parts[1]);
                    String categoryName = parts[2];
                    Expense expense = new Expense(description, amount, categoryName);
                    budget.expenses.add(expense);
                }
            }
        }

        Utils.typeLine("Budget loaded successfully.");
        return budget;
    }
}
