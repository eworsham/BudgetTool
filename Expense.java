// Class to represent an expense
// This class contains details about an expense such as description, amount, and category
public class Expense {
    private String description;
    private double amount;
    private String categoryName;

    // Constructor to initialize expense with description, amount, and category name
    public Expense(String description, double amount, String categoryName) {
        this.description = description;
        this.amount = amount;
        this.categoryName = categoryName;
    }

    // Method to display expense details
    public void displayExpense() {
        Utils.typeLine("    Expense: " + description + ", Amount: $" + amount + ", Category: " + categoryName);
    }

    // Override toString method to return expense details as a string for file writing
    @Override
    public String toString() {
        return "Expense:" + description + "," + amount + "," + categoryName;
    }
}
