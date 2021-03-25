package L10ForLoopMoreExercises;

import java.util.Scanner;

public class P01BackToThePast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double inheritedSum = Double.parseDouble(scan.nextLine());
        int finalYear = Integer.parseInt(scan.nextLine());

        double neededSum = 0;
        int age = 18;

        for (int year = 1800; year <= finalYear; year++) {
            if (year % 2 == 0) {
                neededSum += 12000;
            } else {
                neededSum += 12000 + (50 * age);
            }
            age++;
        }

        double moneyDifference = Math.abs(inheritedSum - neededSum);

        if (inheritedSum >= neededSum) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", moneyDifference);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", moneyDifference);
        }
    }
}
