// Class to represent a budget category
// Contains methods to manage category details and display information
public class Category {
    private String name;
    private double budget;

    // Constructor to initialize category with name and budget
    public Category(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    // Getter for category name
    public String getName() {
        return name;
    }

    // Getter for category budget
    public double getBudget() {
        return budget;
    }

    // Method to display category details
    public void displayCategory() {
        Utils.typeLine("Category: " + name + ", Budget: $" + budget);
    }
}
