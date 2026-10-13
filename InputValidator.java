import java.util.Scanner;

public class InputValidator {

    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String message, int min, int max) {
        int number = 0;
        boolean valid = false;

        while (valid == false) {
            System.out.print(message);
            String text = scanner.nextLine().trim();

            try {
                number = Integer.parseInt(text);

                if (number >= min && number <= max) {
                    valid = true;
                } else {
                    System.out.println("  [!] Number must be between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("  [!] Please enter a whole number (example: 25).");
            }
        }

        return number;
    }

    public static int readValue(String message) {
        return readInt(message, -9999, 9999);
    }
}
