package L12WhileLoopMoreExcercises;

import java.util.Scanner;

public class P02ReportSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int peopleCount = 1;
        int cashPayment = 0;
        int cashPaymentCnt = 0;
        int cardPayment = 0;
        int cardPaymentCnt = 0;

        while (!command.equals("End")) {
            int payment = Integer.parseInt(command);
            if (peopleCount % 2 != 0) {
                // has to be cash
                if (payment <= 100) {
                    cashPayment += payment;
                    cashPaymentCnt++;
                    System.out.println("Product sold!");
                } else {
                    System.out.println("Error in transaction!");
                }
            } else {
                // has to be card
                if (payment >= 10) {
                    cardPayment += payment;
                    cardPaymentCnt++;
                    System.out.println("Product sold!");
                } else {
                    System.out.println("Error in transaction!");
                }
            }

            if (sum <= (cashPayment + cardPayment)) break;
            peopleCount++;
            command = scan.nextLine();

        }

        if (command.equals("End")){
            System.out.printf("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f\n", (cashPayment / (double)cashPaymentCnt));
            System.out.printf("Average CC: %.2f", (cardPayment / (double)cardPaymentCnt));
        }
    }
}
