package LFE03ProgrammingFundamentalsFinalExamRetake;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

public class P02MirrorWords {
    private static final String PATTERN = "(@|#)(?<word1>[A-Za-z]{3,})\\1\\1(?<word2>[A-Za-z]{3,})\\1";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(input);

        List<String> pairs = new ArrayList<>();

        while (matcher.find()) {
            pairs.add(String.format("%s <=> %s", matcher.group("word1"), matcher.group("word2")));
        }

        if (pairs.size() == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!\n", pairs.size());
        }

        List<String> mirrored = new ArrayList<>();

        pairs.forEach(pair -> {
            String[] words = pair.split(" <=> ");
            StringBuilder reversed = new StringBuilder(words[1].length());
            reversed = reversed.append(words[1]).reverse();
//            words[1].chars().forEach(c -> reversed.insert(0, (char) c));
            if (words[0].equals(reversed.toString())) {
                mirrored.add(pair);
            }
        });

        if (mirrored.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.printf("The mirror words are: \n%s", String.join(", ", mirrored));
        }
    }
}
