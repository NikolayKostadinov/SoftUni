package L18RegularExpressionsMoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();

        while (!"end".equals(input)) {
            String text = decode(input, key);
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-\\!:>]*?!(?<behaviour>G)!");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find() ) {
                System.out.println(matcher.group("name"));
            }
            input = scan.nextLine();
        }
    }

    private static String decode(String input, int key) {
        StringBuilder sb = new StringBuilder(input.length());
        for (char chr : input.toCharArray()) {
            sb.append((char) (chr - key));
        }
        return sb.toString();
    }
}
