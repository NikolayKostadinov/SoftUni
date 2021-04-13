package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019v2;

import java.util.Scanner;

public class P04MovieStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String actorName = scan.nextLine();
        double sum = 0;
        while (!"ACTION".equals(actorName)) {
            double price = 0;

            if (actorName.length() > 15) {
                price = (budget - sum) * 0.20;
            } else {
                price = Double.parseDouble(scan.nextLine());
            }

            sum += price;
            if (sum >= budget) break;
            actorName = scan.nextLine();
        }

        double difference = Math.abs(budget - sum);
        if (budget >= sum) {
            System.out.printf("We are left with %.2f leva.", difference);
        } else {
            System.out.printf("We need %.2f leva for our actors.", difference);
        }
    }
}
