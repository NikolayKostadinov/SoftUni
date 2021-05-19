package TheExam;

import java.util.Scanner;

public class P01ChristmasPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int paperRolls = Integer.parseInt(scan.nextLine());
        int fabricRolls = Integer.parseInt(scan.nextLine());
        double glue = Double.parseDouble(scan.nextLine());
        int discount = Integer.parseInt(scan.nextLine());

        double sum = (paperRolls * 5.8 + fabricRolls * 7.2 + glue * 1.2) * ((100 - discount) / 100.0);

        System.out.printf("%.3f", sum);

    }
}
