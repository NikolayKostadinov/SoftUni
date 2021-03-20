package L06ConditionalStatementsExercise;

import java.util.Scanner;

public class P06GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double movieBudget = Double.parseDouble(scan.nextLine());
        int extraCount = Integer.parseInt(scan.nextLine());
        double dressPrice = Double.parseDouble(scan.nextLine());

        double dressesBudget = movieBudget - (movieBudget * 0.1);
        double dressesPrice = extraCount * dressPrice;

        if (extraCount > 150) {
            dressesPrice *= 0.9;
        }

        double difference = Math.abs(dressesBudget - dressesPrice);
        if (dressesPrice > dressesBudget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", difference);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", difference);
        }

    }
}
