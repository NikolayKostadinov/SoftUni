package L09ForLoop;

import java.util.Scanner;

public class P11CleverLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double washingMachinePrice = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());

        int toysMoney = 0;
        double savedSum = 0;

        int present = 10;
        for (int i = 1; i <= age ; i++) {
            if( i % 2 == 0) {
                savedSum += (present - 1);
                present+=10;
            } else {
              toysMoney += toyPrice;
            }
        }

        savedSum += toysMoney;

        double difference = Math.abs(washingMachinePrice - savedSum);

        if(washingMachinePrice <= savedSum) {
            System.out.printf("Yes! %.2f", difference);
        } else {
            System.out.printf("No! %.2f", difference);
        }
    }
}
