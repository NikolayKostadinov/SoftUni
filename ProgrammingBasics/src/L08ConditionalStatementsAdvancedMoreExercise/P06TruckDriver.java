package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P06TruckDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String season = scan.nextLine();
        double kilometers = Double.parseDouble(scan.nextLine());

        double kilometerPrice = 0;
        if (kilometers <= 5000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    kilometerPrice = 0.75;
                    break;

                case "Summer":
                    kilometerPrice = 0.90;
                    break;

                case "Winter":
                    kilometerPrice = 1.05;
                    break;
            }
        } else if (5000 < kilometers && kilometers <= 10000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    kilometerPrice = 0.95;
                    break;

                case "Summer":
                    kilometerPrice = 1.10;
                    break;

                case "Winter":
                    kilometerPrice = 1.25;
                    break;
            }
        } else if (10000 < kilometers && kilometers <= 20000) {
            kilometerPrice = 1.45;
        }

        double payment = kilometerPrice * kilometers * 4.0 * 0.9;
        System.out.printf("%.2f", payment);
    }
}
