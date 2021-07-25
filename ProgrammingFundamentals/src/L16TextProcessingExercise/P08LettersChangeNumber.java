package L16TextProcessingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P08LettersChangeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var ref = new Object() {
            double sum = 0.0;
        };
        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(text -> ref.sum += calculateText(text));

        System.out.printf("%.2f", ref.sum);
    }

    private static double calculateText(String text) {
        double result = 0.0;
        char startLetter = text.charAt(0);
        char endLetter = text.charAt(text.length() - 1);

        int number = Integer.parseInt(text.substring(1, text.length() - 1));

        if (Character.isUpperCase(startLetter)) {
            double divider = startLetter - 'A' + 1;
            result = number / divider;
        } else {
            double multiplier = startLetter - 'a' + 1;
            result = number * multiplier;
        }

        if (Character.isUpperCase(endLetter)) {
            double substractor = endLetter - 'A' + 1;
            result -= substractor;
        } else {
            double addend = endLetter - 'a' + 1;
            result += addend;
        }

        return result;
    }
}
