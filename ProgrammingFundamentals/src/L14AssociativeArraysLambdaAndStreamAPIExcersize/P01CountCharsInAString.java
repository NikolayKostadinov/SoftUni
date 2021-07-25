package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character currentSymbol = text.charAt(i);
            if (currentSymbol == ' ') continue;
            if (!chars.containsKey(currentSymbol)){
                chars.put(currentSymbol,0);
            }
            chars.put(currentSymbol, chars.get(currentSymbol) + 1);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
