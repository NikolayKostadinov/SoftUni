package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v2;

import java.util.Scanner;

public class P06TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int dailyWins = 0;
        double sum = 0;

        for (int i = 0; i < days; i++) {
            String command = scan.nextLine();
            int wins = 0;
            int loses = 0;
            while(!"Finish".equals(command)){
                if ("win".equals(scan.nextLine())){
                    wins++;
                }else{
                    loses++;
                }
                command = scan.nextLine();
            }

            double dailySum = wins * 20.0;
            if (wins > loses) {
                dailySum *= 1.1;
                dailyWins++;
            }
            sum += dailySum;
        }

        if (days / 2 < dailyWins) {
            System.out.printf("You won the tournament! Total raised money: %.2f", sum * 1.2);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", sum);
        }
    }
}
