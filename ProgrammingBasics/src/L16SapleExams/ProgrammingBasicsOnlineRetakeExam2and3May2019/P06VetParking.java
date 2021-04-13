package L16SapleExams.ProgrammingBasicsOnlineRetakeExam2and3May2019;

import java.util.Scanner;

public class P06VetParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());

        double sum = 0;
        for (int day = 1; day <= days; day++) {
            double dailySum = 0;
            for (int hour = 1; hour <= hours; hour++) {
                if (day % 2 == 0 && hour % 2 != 0) dailySum += 2.5;
                else if (day % 2 != 0 && hour % 2 == 0) dailySum += 1.25;
                else dailySum += 1;
            }
            System.out.printf("Day: %d - %.2f leva\n", day, dailySum);
            sum += dailySum;
        }

        System.out.printf("Total: %.2f leva", sum);

    }
}
