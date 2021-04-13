package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class P05Series {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int seriesCount = Integer.parseInt(scan.nextLine());
        double price = 0;

        for (int i = 0; i < seriesCount; i++) {
            String name = scan.nextLine();
            double seriesPrice = Double.parseDouble(scan.nextLine());

            switch (name){
                case "Thrones":
                    seriesPrice *= 0.5;
                    break;
                case "Lucifer":
                    seriesPrice *= 0.6;
                    break;
                case "Protector":
                    seriesPrice *= 0.7;
                    break;
                case "TotalDrama":
                    seriesPrice *= 0.8;
                    break;
                case "Area":
                    seriesPrice *= 0.9;
                    break;
            }

            price += seriesPrice;
        }

        double difference = Math.abs(budget - price);

        if (budget >= price){
            System.out.printf("You bought all the series and left with %.2f lv.", difference);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", difference);
        }

    }
}
