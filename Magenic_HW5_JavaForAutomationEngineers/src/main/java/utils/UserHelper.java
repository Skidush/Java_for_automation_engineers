package utils;

import models.MovieStoreUser;

import java.util.Scanner;

public class UserHelper {
    private static final Scanner scanner = new Scanner(System.in);
    public static int displayOptionsAndWaitForInput(String[] options) {
        // Prints the options
        printOptions(options);

        return validateUserInput(options);
    }

    public static String takeUserInputAsString() {
        return scanner.nextLine();
    }

    public static int validateUserInput(String[] options) {
        // An infinite to ensure the user selects a valid option
        do {
            int option = -1;

            // Reads the user input
            String input = takeUserInputAsString();

            // Tries to parse the input to an integer
            try {
                option = Integer.parseInt(input);

                // If the option if not negative or outside the scope of the options, return that option as it is valid and ends the loop
                if (option >= 0 && option <= options.length - 1) {
                    return option;
                }

                // Prints the options again as the input was not valid
                promptInvalidInput(options);
            } catch(NumberFormatException e) {
                // Catches any parsing error and re-prompts the user
                promptInvalidInput(options);
            }
        } while (true);
    }

    public static void printOptions(String[] options) {
        // For each element in the array print the index and the element
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + ". " + options[i]);
        }

        System.out.print("Option to select: ");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void promptInvalidInput(String[] options) {
        System.out.println("===== You have entered an invalid option. Please try again! =====");
        clearConsole();
        printOptions(options);
    }

    public static MovieStoreUser authorizeUser(String username, String password) {
        return TestData.users.stream()
                .filter(user -> user.getUsername().equals((username)) && user.getPassword().equals(password))
                .findAny()
                .orElse(null);
    }
}
