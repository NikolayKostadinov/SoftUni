package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v1;

import java.util.Scanner;

public class P02EasterParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int guestsCount = Integer.parseInt(scan.nextLine());
        double price = Double.parseDouble(scan.nextLine());
        double budget = Double.parseDouble(scan.nextLine());

        if (10<=guestsCount && guestsCount <= 15) price *= 0.85;
        else if (15 < guestsCount && guestsCount <= 20) price *= 0.8;
        else if (20 < guestsCount) price *= 0.75;

        double sum = guestsCount * price + budget * 0.1;

        double difference = Math.abs(budget - sum);

        if (budget >= sum){
            System.out.printf("It is party time! %.2f leva left.", difference);
        } else {
            System.out.printf("No party! %.2f leva needed.", difference);
        }

    }
}
