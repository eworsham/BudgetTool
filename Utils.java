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
}
