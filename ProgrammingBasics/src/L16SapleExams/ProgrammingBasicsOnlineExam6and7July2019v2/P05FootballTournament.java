package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v2;

import java.util.Scanner;

public class P05FootballTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String teamName = scan.nextLine();

        int gamesCount = Integer.parseInt(scan.nextLine());
        if (gamesCount == 0) {
            System.out.printf("%s hasn't played any games during this season.", teamName);
            return;
        }

        int score = 0;
        int wins = 0;
        int dues = 0;
        int losses = 0;

        for (int i = 0; i < gamesCount; i++) {
            switch (scan.nextLine()) {
                case "W":
                    wins++;
                    score += 3;
                    break;
                case "D":
                    dues++;
                    score++;
                    break;
                case "L":
                    losses++;
                    break;
            }
        }

        System.out.printf("%s has won %d points during this season\n", teamName, score);
        System.out.printf("Total stats:\n");
        System.out.printf("## W: %d\n", wins);
        System.out.printf("## D: %d\n", dues);
        System.out.printf("## L: %d\n", losses);
        System.out.printf("Win rate: %.2f%%\n", (wins/(double)(wins+dues+losses))*100.0);
    }
}
