package L16SapleExams.ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class P05BestPlayer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playerName = scan.nextLine();

        int maxGoals = 0;
        String maxPlayerName = "";
        while (!"END".equals(playerName)) {
            int goals = Integer.parseInt(scan.nextLine());
            if (goals > maxGoals) {
                maxGoals = goals;
                maxPlayerName = playerName;
            }
            if (goals >= 10) break;
            playerName = scan.nextLine();
        }

        System.out.printf("%s is the best player!\n", maxPlayerName);
        if (maxGoals >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", maxGoals);
        } else {
            System.out.printf("He has scored %d goals.", maxGoals);
        }
    }
}
