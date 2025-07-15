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

    // Method to add an expense given a description, amount, and  a category
    public void addExpense(String description, double amount, String categoryName) {
        Expense expense = new Expense(description, amount, categoryName);
        expenses.add(expense);
        Utils.typeLine("Expense added: " + description + " for $" + amount + " in category " + categoryName);
    }

    // Methods to view category balances
    public void viewCategories() {
        if (categories.isEmpty()) {
            Utils.typeLine("No categories available.");
        } else {
            Utils.typeLine("Viewing budget...");
            Utils.typeLine("Categories:");
            for (Category category : categories) {
                category.displayCategory();
            }
        }
    }
}
