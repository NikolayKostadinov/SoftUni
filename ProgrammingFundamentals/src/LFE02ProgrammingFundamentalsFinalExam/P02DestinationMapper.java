package LFE02ProgrammingFundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String ptr = "(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(ptr);
        Matcher matcher = pattern.matcher(input);

        int points = 0;
        List<String> destinations = new ArrayList<>();

        while (matcher.find()){
            String destination = matcher.group("destination");
            points += destination.length();
            destinations.add(destination);
        }

        System.out.printf("Destinations: %s%n", String.join(", ", destinations));
        System.out.printf("Travel Points: %d%n", points);
    }
}
