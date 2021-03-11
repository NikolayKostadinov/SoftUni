package L06ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P03Harvest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int vineyardArea = Integer.parseInt(scan.nextLine());
        double grapePerSqMeter = Double.parseDouble(scan.nextLine());
        int neededLitersWine = Integer.parseInt(scan.nextLine());
        int workersCount = Integer.parseInt(scan.nextLine());

        double grapeForWine = vineyardArea * grapePerSqMeter * 0.4;
        double wineVolume = grapeForWine / 2.5;

        double wineDifference = Math.abs(neededLitersWine - wineVolume);

        if (wineVolume < neededLitersWine) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(wineDifference));
        } else {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wineVolume));
            System.out.printf("%.0f liters left -> %.0f liters per person.",
                    Math.ceil(wineDifference), Math.ceil(wineDifference / workersCount));
        }
    }
}
