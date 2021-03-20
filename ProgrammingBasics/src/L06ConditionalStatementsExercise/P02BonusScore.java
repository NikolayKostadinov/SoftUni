package L06ConditionalStatementsExercise;

import java.util.Scanner;

public class P02BonusScore {
    public static void main(String[] args) {
        //TODO: Get input
        Scanner scan = new Scanner(System.in);
        int points = Integer.parseInt(scan.nextLine());

        //TODO: Calculate Score
        double bonusScores = 0;
        if (points <= 100) {
            bonusScores = 5;
        } else if (points > 1000) {
            bonusScores = points * (10.0 / 100.0);
        } else {
            bonusScores = points * (20.0 / 100.0);
        }

        if (points % 2 == 0) {
            bonusScores = bonusScores + 1;
        } else if (points % 10 == 5) {
            bonusScores = bonusScores + 2;
        }

        System.out.println(bonusScores);
        System.out.println(points + bonusScores);
    }
}
