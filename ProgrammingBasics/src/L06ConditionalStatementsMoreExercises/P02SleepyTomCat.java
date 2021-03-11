package L06ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int holidays = Integer.parseInt(scan.nextLine());
        int workingDays = 365 - holidays;

        int playtimePerYear = workingDays * 63 + holidays * 127;

        int timeDifference = Math.abs(playtimePerYear - 30000);

        if (playtimePerYear > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", timeDifference / 60, timeDifference % 60);
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", timeDifference / 60, timeDifference % 60);
        }
    }
}
