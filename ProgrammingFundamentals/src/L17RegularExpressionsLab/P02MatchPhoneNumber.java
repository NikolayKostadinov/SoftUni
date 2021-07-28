package L17RegularExpressionsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MatchPhoneNumber {
    public static final String PATTERN="\\+359( |-)2\\1\\d{3}\\1\\d{4}\\b";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(text);

        List<String> phoneNumbers = new ArrayList<>();
        while (matcher.find()){
            phoneNumbers.add(matcher.group());
        }

        System.out.println(String.join(", ", phoneNumbers));
    }
}
