package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v1;

import java.util.Scanner;

public class P06TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int wins = 0;
        int loses = 0;
        double sum = 0;
        for (int i = 1; i <= days; i++) {
            int dailyWins = 0;
            int dailyLoses = 0;
            double dailySum = 0;
            String command = scan.nextLine();
            while (!"Finish".equals(command)) {
                if ("win".equals(scan.nextLine())) {
                    dailySum += 20;
                    dailyWins++;
                } else {
                    dailyLoses++;
                }
                command = scan.nextLine();
            }

            if (dailyWins > dailyLoses) {
                dailySum *= 1.1;
                wins++;
            } else {
                loses++;
            }

            sum += dailySum;
        }

        if (wins > loses) {
            sum *= 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", sum);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", sum);
        }
    }
}
