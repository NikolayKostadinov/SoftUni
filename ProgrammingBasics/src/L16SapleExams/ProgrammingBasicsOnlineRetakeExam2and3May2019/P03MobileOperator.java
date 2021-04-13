package L16SapleExams.ProgrammingBasicsOnlineRetakeExam2and3May2019;

import java.util.Scanner;

public class P03MobileOperator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String years = scan.nextLine();
        String type = scan.nextLine();
        String isInternetAdded = scan.nextLine();
        int months = Integer.parseInt(scan.nextLine());

        double monthlyPrice = 0;

        switch (type) {
            case "Small":
                monthlyPrice = (years.equals("one")) ? 9.98 : 8.58;
                break;
            case "Middle":
                monthlyPrice = (years.equals("one")) ? 18.99 : 17.09;
                break;
            case "Large":
                monthlyPrice = (years.equals("one")) ? 25.98 : 23.59;
                break;
            case "ExtraLarge":
                monthlyPrice = (years.equals("one")) ? 35.99 : 31.79;
                break;
        }

        double internetPrice = 0;

        if (isInternetAdded.equals("yes")) {
            if (monthlyPrice <= 10) internetPrice = 5.5;
            else if (monthlyPrice <= 30) internetPrice = 4.35;
            else if (monthlyPrice > 30) internetPrice = 3.85;
        }

        double sum = (monthlyPrice + internetPrice) * months;

        if (years.equals("two")) sum *= (100.0 - 3.75) / 100.0;

        System.out.printf("%.2f lv.", sum);
    }
}
