package L16TextProcessingMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P06WinningTicket {
    public static final List<String> treasureChars =
            new ArrayList<>() {{
                add("@");
                add("#");
                add("$");
                add("^");
            }};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arrays.stream(scan.nextLine().split("\\s*,\\s*"))
                .forEach(ticket -> checkWinning(ticket));
    }

    private static void checkWinning(String ticket) {

        if (ticket.length() != 20) {
            System.out.println("invalid ticket");
            return;
        }

        String leftHalf = ticket.substring(0, 10);
        String rightHalf = ticket.substring(10);

        int maxLen = 0;
        String maxChar = "";

        for (String treasureChar : treasureChars) {
            for (int i = 6; i <= 10; i++) {
                String template = treasureChar.repeat(i);
                if (leftHalf.contains(template) && rightHalf.contains(template) && i > maxLen) {
                    maxLen = i;
                    maxChar = treasureChar;
                }
            }
        }
        if (maxLen > 0) {
            System.out.printf("ticket \"%s\" - %d%s\n", ticket, maxLen, (maxLen < 10) ? maxChar : maxChar + " Jackpot!");
        } else {
            System.out.printf("ticket \"%s\" - no match\n", ticket);
        }
    }
}
