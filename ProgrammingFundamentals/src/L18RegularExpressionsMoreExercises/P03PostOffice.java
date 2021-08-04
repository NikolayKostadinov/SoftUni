package L18RegularExpressionsMoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] tokens = input.split("\\|");

        Pattern pattern = Pattern.compile("([#$%*&])(?<start>[A-Z]+)\\1");
        Matcher matcher = pattern.matcher(tokens[0]);
        char startChars[] = null;

        while (matcher.find()) {
            startChars = matcher.group("start").toCharArray();
        }

        for (char startChar : startChars) {
            String ptr = String.format("%d:(?<length>\\d{2})", (int)startChar);
            pattern = Pattern.compile(ptr);
            matcher = pattern.matcher(tokens[1]);
            if (matcher.find()){
                int length = Integer.parseInt(matcher.group("length"));
                ptr = String.format("(^|\\s)(?<word>%c\\S{%d})(\\s|$)", startChar,length);
                Pattern wordPattern = Pattern.compile(ptr);
                Matcher wordMatcher = wordPattern.matcher(tokens[2]);

                if (wordMatcher.find()){
                    System.out.println(wordMatcher.group("word"));
                }
            }
        }
    }
}
