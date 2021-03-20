package L08ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P09Volleyball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String yearType = scan.nextLine();
        int holidaysCount = Integer.parseInt(scan.nextLine());
        int tripsToHomeCount = Integer.parseInt(scan.nextLine());

        double gamesCount = ((48-tripsToHomeCount) * 3.0/4.0) + tripsToHomeCount + holidaysCount * 2.0 / 3.0;

        if (yearType.equalsIgnoreCase("leap")){
            gamesCount *= 1.15;
        }

        System.out.println((int)Math.floor(gamesCount));
    }
}
