package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019v2;

import java.util.Scanner;

public class P02MovieDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int shootingTime = Integer.parseInt(scan.nextLine());
        int stagesCount = Integer.parseInt(scan.nextLine());
        int timePerStage = Integer.parseInt(scan.nextLine());

        double neededTime = (stagesCount * timePerStage) + shootingTime * 0.15;

        int difference = (int) Math.round( Math.abs(shootingTime - neededTime));
        if (shootingTime >= neededTime){
            System.out.printf("You managed to finish the movie on time! You have %d minutes left!", difference );
        } else {
            System.out.printf("Time is up! To complete the movie you need %d minutes.", difference );
        }
    }
}
