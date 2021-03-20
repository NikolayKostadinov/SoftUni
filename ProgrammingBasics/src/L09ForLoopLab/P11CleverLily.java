package L09ForLoopLab;

import java.util.Scanner;

public class P11CleverLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double washingMachinePrice = Double.parseDouble(scan.nextLine());
        double toyPrice = Double.parseDouble(scan.nextLine());
        double toysSum = 0;
        int birthdaySum = 0;

        int present = 10;
        for (int i = 1; i <= age ; i++) {
            if( i % 2 == 0) {
                birthdaySum += (present - 1.00);
                present+=10;
            } else {
              toysSum += toyPrice;
            }
        }

        double sum = birthdaySum + toysSum;

        double difference = Math.abs(washingMachinePrice - sum);

        if(washingMachinePrice < sum) {
            System.out.printf("Yes! %.2f", difference);
        } else {
            System.out.printf("No! %.2f", difference);
        }
    }
}
