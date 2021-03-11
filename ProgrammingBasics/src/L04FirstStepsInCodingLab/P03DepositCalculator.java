package L04FirstStepsInCodingLab;

import java.util.Scanner;

public class P03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double depositedАmount = Double.parseDouble(scanner.nextLine());
        byte depositPeriodMonths = Byte.parseByte(scanner.nextLine());
        double interestRate = Double.parseDouble(scanner.nextLine());
        //сума = депозирана сума  + срок на депозита * ((депозирана сума * годишен лихвен процент ) / 12)
        double sum = depositedАmount + depositPeriodMonths *((depositedАmount * (interestRate/100.0)) / 12.0);

        System.out.printf("%.2f", sum);
    }
}
