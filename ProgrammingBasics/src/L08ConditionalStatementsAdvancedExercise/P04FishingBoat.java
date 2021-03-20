package L08ConditionalStatementsAdvancedExercise;

import java.util.Locale;
import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermanCount = Integer.parseInt(scanner.nextLine());

        double discount = 0;
        if (fishermanCount <= 6) {
            discount = 0.1;
        } else if (7 < fishermanCount && fishermanCount <= 11) {
            discount = 0.15;
        } else if (fishermanCount >= 12) {
            discount = 0.25;
        }

        double price = 0;

        switch (season.toLowerCase(Locale.ROOT)) {
            case "spring":
                price = 3000 * (1.0 - discount);
                break;
            case "summer":
            case "autumn":
                price = 4200 * (1.0 - discount);
                break;
            case "winter":
                price = 2600 * (1.0 - discount);
                break;
        }

        if (!season.equalsIgnoreCase("autumn") && (fishermanCount % 2 == 0)) {
            price -= price * 0.05;
        }

        double difference = Math.abs(budget - price);

        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", difference);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", difference);
        }
    }
}
