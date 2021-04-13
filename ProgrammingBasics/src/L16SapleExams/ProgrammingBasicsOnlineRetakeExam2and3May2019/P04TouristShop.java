package L16SapleExams.ProgrammingBasicsOnlineRetakeExam2and3May2019;

import java.util.Scanner;

public class P04TouristShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String productName = scan.nextLine();

        double sum = 0;
        int productCount = 0;
        while (!"Stop".equals(productName)){
            productCount++;
            double productPrice = Double.parseDouble(scan.nextLine());
            if (productCount % 3 == 0) productPrice /= 2.0;
            sum += productPrice;
            if (sum > budget) break;
            productName = scan.nextLine();
        }

        if ("Stop".equals(productName)){
            System.out.printf("You bought %d products for %.2f leva.", productCount, sum);
        } else {
            System.out.println("You don't have enough money!");
            System.out.printf("You need %.2f leva!", sum - budget);
        }
    }
}
