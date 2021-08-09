package L18RegularExpressionsMoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01WinningTicket {
    public static final String PATTERN =
            "(?=.{20}).*?(?<winch>[@#$^]{6,10}).*?(?<=.{10}).*?\\k<winch>.*?(?<=.{10})";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split("\\s*,\\s*");
        Pattern pattern = Pattern.compile(PATTERN);
        for (String ticket : tickets) {
            if (ticket.length() == 20) {
                Matcher matcher = pattern.matcher(ticket);
                if (matcher.find()) {
                    String found = matcher.group("winch");
                    System.out.printf("ticket \"%s\" - %d%c", ticket, found.length(), found.charAt(0));
                    if (found.length() == 10) {
                        System.out.print(" Jackpot!");
                    }
                    System.out.println();
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
