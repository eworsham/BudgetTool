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

    // Method to get the name of the category
    public String getName() {
        return name;
    }

    // Method to get the budget for the category
    public double getBudget() {
        return budget;
    }

    // Method to set the budget for the category
    public void setBudget(double budget) {
        this.budget = budget;
    }

    // Method to display category details
    public void displayCategory() {
        Utils.typeLine("    Category: " + name + ", Budget: $" + budget);
    }
}
