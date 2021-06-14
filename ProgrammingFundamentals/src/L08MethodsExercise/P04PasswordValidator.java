package L08MethodsExercise;

import java.util.Locale;
import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        System.out.println(checkPassword(password));
    }

    private static String checkPassword(String password) {
        StringBuilder errors = new StringBuilder();
        errors.append(checkLength(password));
        errors.append(checkFormat(password));
        errors.append(checkNumbers(password));

        if (errors.length() == 0) errors.append("Password is valid");

        return errors.toString();
    }

    private static String checkNumbers(String password) {
        int countNumbers = 0;

        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.toLowerCase(Locale.ROOT).charAt(i);
            if ('0' <= currentChar && currentChar <= '9') countNumbers++;
        }

        return (countNumbers < 2) ? "Password must have at least 2 digits\n" : "";
    }

    private static String checkFormat(String password) {
        String result = "";
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.toLowerCase(Locale.ROOT).charAt(i);
            if (!(('0' <= currentChar && currentChar <= '9')
                    || ('a' <= currentChar && currentChar <= 'z'))) {
                result = "Password must consist only of letters and digits\n";
            }
        }

        return result;
    }

    private static String checkLength(String password) {
        String result = "";
        if (6 > password.length() || password.length() > 10) {
            result = "Password must be between 6 and 10 characters\n";
        }
        return result;
    }
}