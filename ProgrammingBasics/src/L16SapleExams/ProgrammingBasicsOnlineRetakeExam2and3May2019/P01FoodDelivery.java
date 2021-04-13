package L16SapleExams.ProgrammingBasicsOnlineRetakeExam2and3May2019;

import java.util.Scanner;

public class P01FoodDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int chickenCount = Integer.parseInt(scan.nextLine());
        int fishCount = Integer.parseInt(scan.nextLine());
        int vegetarianCount = Integer.parseInt(scan.nextLine());

        double result = (chickenCount * 10.35 + fishCount * 12.40 + vegetarianCount * 8.15) * 1.2 + 2.5;

        System.out.printf("Total: %.2f", result);

    }
}
