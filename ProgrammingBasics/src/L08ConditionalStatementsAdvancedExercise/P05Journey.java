package L08ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P05Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String destination = "";
        String vacationType = season.equalsIgnoreCase("summer") ? "Camp" : "Hotel";
        double spentSum = 0;

        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equalsIgnoreCase("summer")) {
                spentSum = budget * 0.3;
            } else if (season.equalsIgnoreCase("winter")) {
                spentSum = budget * 0.7;
            }
        } else if (100 < budget && budget <= 1000) {
            destination = "Balkans";
            if (season.equalsIgnoreCase("summer")) {
                spentSum = budget * 0.4;
            } else if (season.equalsIgnoreCase("winter")) {
                spentSum = budget * 0.8;
            }
        } else if (budget > 1000) {
            destination = "Europe";
            vacationType = "Hotel";
            spentSum = budget * 0.9;
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", vacationType, spentSum);
    }
}
