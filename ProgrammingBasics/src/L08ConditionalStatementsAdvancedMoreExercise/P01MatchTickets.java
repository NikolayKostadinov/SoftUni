package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P01MatchTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String category = scan.nextLine();
        int groupCount = Integer.parseInt(scan.nextLine());

        double ticketPrice = groupCount * ((category.equalsIgnoreCase("vip")) ? 499.99 : 249.99);

        double transportPrice = 0;
        if (1 <= groupCount && groupCount <= 4) transportPrice = budget * 0.75;
        else if (5 <= groupCount && groupCount <= 9) transportPrice = budget * 0.60;
        else if (10 <= groupCount && groupCount <= 24) transportPrice = budget * 0.50;
        else if (25 <= groupCount && groupCount <= 49) transportPrice = budget * 0.40;
        else if (50 <= groupCount) transportPrice = budget * 0.25;

        double difference = Math.abs(budget - ticketPrice - transportPrice);
        if (budget >= (ticketPrice + transportPrice)) {
            System.out.printf("Yes! You have %.2f leva left.", difference);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", difference);
        }
    }
}
