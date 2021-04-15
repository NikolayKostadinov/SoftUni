package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v1;

import java.util.Scanner;

public class P05TennisRanklist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tournamentsCount = Integer.parseInt(scan.nextLine());
        int startPoints = Integer.parseInt(scan.nextLine());
        int won = 0;
        int points = 0;

        for (int i = 0; i < tournamentsCount; i++) {
            String etap = scan.nextLine();

            switch (etap){
                case "W":
                    won++;
                    points += 2000;
                    break;
                case "F":
                    points += 1200;
                    break;
                case "SF":
                    points += 720;
                    break;
            }
        }

        System.out.printf("Final points: %d\n", points + startPoints);
        System.out.printf("Average points: %d\n",(int)Math.floor(points / (double)tournamentsCount));
        System.out.printf("%.2f%%", won * 100 / (double)tournamentsCount );
    }
}
