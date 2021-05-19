package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var typeOfDay = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        int price = 0;

        if (0 > age || age > 122) {
            System.out.println("Error!");
            return;
        }

        if (typeOfDay.equals("Weekday")) {
            if ((0 <= age && age <= 18) || (64 < age && age <= 122)) {
                price = 12;
            } else if (18 < age && age <= 64) {
                price = 18;
            }
        } else if (typeOfDay.equals("Weekend")) {
            if ((0 <= age && age <= 18) || (64 < age && age <= 122)) {
                price = 15;
            } else if (18 < age && age <= 64) {
                price = 20;
            }
        } else if (typeOfDay.equals("Holiday")) {
            if (0 <= age && age <= 18) {
                price = 5;
            } else if (18 < age && age <= 64) {
                price = 12;
            } else if (64 < age && age <= 122) {
                price = 10;
            }
        }

        System.out.println(price + "$");
    }
}
