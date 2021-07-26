package L15TextProcessing;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> bannedWords = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toMap(x->x, x->x.length()));

        String text = scan.nextLine();

        for (Map.Entry<String, Integer> word : bannedWords.entrySet()) {
            text = text.replaceAll(word.getKey(), "*".repeat(word.getValue()));
        }

        System.out.println(text);
    }
}
