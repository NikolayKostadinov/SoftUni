package L18RegularExpressionsMoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02RageQuit {
    private static final String PATTERN = "((?<symbols>\\D+)(?<count>\\d+))";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(input);
        StringBuilder message = new StringBuilder();

        while (matcher.find()) {
            String symbols = matcher.group("symbols").toUpperCase();
            int count = Integer.parseInt(matcher.group("count"));
            for (int i = 0; i < count; i++) {
                message.append(symbols);
            }
        }

        System.out.printf("Unique symbols used: %d%n", message.chars().distinct().count());
        System.out.println(message);
    }
}