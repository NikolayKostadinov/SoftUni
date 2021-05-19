package TheExam;

import java.util.Scanner;

public class P02FootballKit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tShirtPrice = Double.parseDouble(scan.nextLine());
        double targetSum = Double.parseDouble(scan.nextLine());

        double shortPrice = tShirtPrice * 0.75;
        double socksPrice = shortPrice * 0.2;
        double shoosPrice = (tShirtPrice + shortPrice) * 2.0;

        double sum = (tShirtPrice + shortPrice + socksPrice + shoosPrice) * 0.85;

        if (sum >= targetSum){
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", sum);
        } else {
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", targetSum - sum);
        }
    }
}
