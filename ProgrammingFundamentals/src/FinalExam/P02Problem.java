package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02Problem {
    private static final String PATTERN =
            "(\\*|@)(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<letter1>[A-Za-z])\\]\\|\\[(?<letter2>[A-Za-z])\\]\\|\\[(?<letter3>[A-Za-z])\\]\\|$";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Pattern pattern = Pattern.compile(PATTERN);

        for (int i = 0; i < n; i++) {
            Matcher matcher = pattern.matcher(scan.nextLine());
            if (matcher.find()){
                System.out.printf("%s: %d %d %d\n", matcher.group("tag"),
                        (int)matcher.group("letter1").charAt(0),
                        (int)matcher.group("letter2").charAt(0),
                        (int)matcher.group("letter3").charAt(0));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
