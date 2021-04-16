package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v2;

import java.util.Scanner;

public class P02EasterGuests {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int guestsCount = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());

        int eggsCount = guestsCount * 2;
        int cakesCount = (int) Math.ceil(guestsCount / 3.0);
        double sum = eggsCount * 0.45 + cakesCount * 4.0;

        double difference = Math.abs(budget - sum);

        if (budget >= sum) {
            System.out.printf("Lyubo bought %d Easter bread and %d eggs.\n", cakesCount, eggsCount);
            System.out.printf("He has %.2f lv. left.\n", difference);
        } else {
            System.out.println("Lyubo doesn't have enough money.");
            System.out.printf("He needs %.2f lv. more.", difference);
        }
    }
}
