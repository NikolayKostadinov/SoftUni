package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019v2;

import java.util.Scanner;

public class P03MovieDestination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String destination = scan.nextLine();
        String season = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());

        double price = 0;
        switch (destination) {
            case "Dubai":
                price = ("Winter".equals(season)) ? 45000 : 40000;
                break;
            case "Sofia":
                price = ("Winter".equals(season)) ? 17000 : 12500;
                break;
            case "London":
                price = ("Winter".equals(season)) ? 24000 : 20250;
                break;
        }

        double sum = price * days;

        switch (destination){
            case "Dubai":
                sum *= 0.7;
                break;
            case "Sofia":
                sum *= 1.25;
                break;
        }

        double difference = Math.abs(budget - sum);

        if (budget >= sum){
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", difference);
        } else {
            System.out.printf("The director needs %.2f leva more!", difference);
        }
    }
}
