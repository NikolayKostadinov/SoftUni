package L16SapleExams.ProgrammingBasicsOnlineRetakeExam2and3May2019;

import java.util.Scanner;

public class P02Safari {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        double fuel = Double.parseDouble(scan.nextLine());
        String day = scan.nextLine();

        double price = fuel * 2.1 + 100;
        if ("Saturday".equals(day)) {
            price *= 0.9;
        } else {
            price *= 0.8;
        }

        double difference = Math.abs(budget - price);
        if (budget >= price){
            System.out.printf("Safari time! Money left: %.2f lv.", difference);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", difference);
        }
    }
}