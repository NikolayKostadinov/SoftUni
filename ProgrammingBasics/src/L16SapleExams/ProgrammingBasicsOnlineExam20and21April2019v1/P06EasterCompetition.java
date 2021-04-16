package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v1;

import java.util.Scanner;

public class P06EasterCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cakesCount = Integer.parseInt(scan.nextLine());

        int maxScore = 0;
        String winner = "";

        for (int i = 0; i < cakesCount; i++) {
            String cookName = scan.nextLine();
            String command = scan.nextLine();
            int total = 0;
            while (!"Stop".equals(command)){
                total += Integer.parseInt(command);
                command = scan.nextLine();
            }
            System.out.printf("%s has %d points.\n", cookName, total);
            if (total > maxScore){
                maxScore = total;
                winner = cookName;
                System.out.printf("%s is the new number 1!\n", cookName);
            }
        }

        System.out.printf("%s won competition with %d points!", winner, maxScore);
    }
}
