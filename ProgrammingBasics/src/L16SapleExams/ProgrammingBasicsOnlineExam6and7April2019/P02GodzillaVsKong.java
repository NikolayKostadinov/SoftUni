package L16SapleExams.ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class P02GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int statistsCount = Integer.parseInt(scan.nextLine());
        double dressPrice = Double.parseDouble(scan.nextLine());

        double decor = budget * 0.1;
        double daressSum = dressPrice * statistsCount;
        if (statistsCount > 150) daressSum *= 0.9;

        double difference = Math.abs(budget - decor - daressSum);

        if (budget < (decor + daressSum)){
            System.out.printf("Not enough money!\nWingard needs %.2f leva more.", difference);
        } else {
            System.out.printf("Action!\nWingard starts filming with %.2f leva left.", difference);
        }
    }
}
