package L18RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractEmails {
    public static final String PATTERN =
            "\\s(?<email>[A-Za-z0-9]+[\\.\\-\\_]?[A-Za-z0-9]*@[A-Za-z]+[\\-A-Za-z]*(\\.[A-Za-z]+[\\-A-Za-z]*)+)";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            System.out.println(matcher.group("email"));
        }
    }
}
