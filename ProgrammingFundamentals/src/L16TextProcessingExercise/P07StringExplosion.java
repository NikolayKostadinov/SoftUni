package L16TextProcessingExercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] textParts = scan.nextLine().split(">");
        int remindLength = 0;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < textParts.length; i++) {
            if (Character.isDigit(textParts[i].charAt(0))) {
                int straight = Integer.parseInt(String.valueOf(textParts[i].charAt(0))) + remindLength;
                if (straight > textParts[i].length()) {
                    remindLength = straight - textParts[i].length();
                } else {
                    result.append(textParts[i].substring(straight));
                }
            } else {
                result.append(textParts[i]);
            }
            if (i < textParts.length - 1) {
                result.append(">");
            }
        }

        System.out.println(result);
    }
}
