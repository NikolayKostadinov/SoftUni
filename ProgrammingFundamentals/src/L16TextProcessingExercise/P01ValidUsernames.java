package L16TextProcessingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arrays.stream(scan.nextLine().split(", "))
                .filter(name -> isValid(name))
                .forEach(name -> System.out.println(name));
        ;
    }

    private static boolean isValid(String name) {
        int length = name.length();
        char[] nameSymbols = name.toCharArray();
        boolean hasAcceptableSymbols = true;
        for (char symbol : nameSymbols) {
            if (!(Character.isAlphabetic(symbol)
                    || Character.isDigit(symbol)
                    || symbol=='-'
            || symbol == '_')){
                hasAcceptableSymbols = false;
                break;
            }
        }
        return 3 <= length && length <= 16
                && hasAcceptableSymbols;
    }
}
