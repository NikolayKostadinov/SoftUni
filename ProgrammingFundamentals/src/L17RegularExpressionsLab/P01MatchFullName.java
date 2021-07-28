package L17RegularExpressionsLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01MatchFullName {
    private static final String PATTERN = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String fullName = matcher.group();
            System.out.printf("%s ", fullName);
        }
    }
}
