import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {

    // Method to create typewriter effect
    public static void typeText(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(25); // Delay 25 milliseconds between characters
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Method to type a line with newline at the end
    public static void typeLine(String text) {
        typeText(text);
        System.out.println(); // Add newline after typing
    }

    // Method to write to an external file given a file name and content
    public static void writeToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName); // Overwrite file if it exists
            writer.write(content);
            writer.close(); // Close the writer to save changes
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read from an external file
    public static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try  {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            // Read file line by line
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return content.toString();
    }
}
