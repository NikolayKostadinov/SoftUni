package L08ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        double rosePrice = 5.0;
        double dahliaPrice = 3.80;
        double tulipPrice = 2.8;
        double narcissusPrice = 3.0;
        double gladiolusPrice = 2.5;

        Scanner scanner = new Scanner(System.in);

        String flowersKind = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        double price = 0;
        switch (flowersKind){
            case "Roses":
                price = (flowersCount > 80) ? rosePrice * 0.9 : rosePrice;
                break;
            case "Dahlias":
                price = (flowersCount > 90) ? dahliaPrice * 0.85 : dahliaPrice ;
                break;
            case "Tulips":
                price = (flowersCount > 80) ? tulipPrice * 0.85 : tulipPrice ;
                break;
            case "Narcissus":
                price = (flowersCount < 120) ? narcissusPrice * 1.15 : narcissusPrice;
                break;
            case "Gladiolus":
                price  = (flowersCount < 80) ? gladiolusPrice * 1.2 : gladiolusPrice;
                break;
        }

        double sum = flowersCount * price;
        double difference = Math.abs(budget - sum);
        if (budget >= sum){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowersKind, difference);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", difference);
        }
    }
}
