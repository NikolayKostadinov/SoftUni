package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v2;

import java.util.Scanner;

public class P06BasketballTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tournamentName = scan.nextLine();
        int winCnt = 0;
        int lostCnt = 0;

        while (!"End of tournaments".equals(tournamentName)){
            int matchesCnt = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < matchesCnt; i++) {
                int myPoints = Integer.parseInt(scan.nextLine());
                int oponentPoints = Integer.parseInt(scan.nextLine());

                int difference = Math.abs(myPoints - oponentPoints);
                if (myPoints > oponentPoints){
                    System.out.printf("Game %d of tournament %s: win with %d points.\n", i+1, tournamentName, difference);
                    winCnt++;
                } else {
                    System.out.printf("Game %d of tournament %s: lost with %d points.\n", i+1, tournamentName, difference);
                    lostCnt++;
                }
            }

            tournamentName = scan.nextLine();
        }

        System.out.printf("%.2f%% matches win\n", winCnt * 100 / ((winCnt+lostCnt) * 1.0));
        System.out.printf("%.2f%% matches lost\n", lostCnt * 100 / ((winCnt+lostCnt) * 1.0) );
    }
}
