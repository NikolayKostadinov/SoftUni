package L04DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int yield = Integer.parseInt(scan.nextLine());
        int totalAmount = 0;
        int numberOfDays = 0;

        while (yield >= 100) {
            totalAmount += yield;
            yield -= 10;
            numberOfDays++;
            if (totalAmount >= 26) totalAmount -= 26; // daily consumption
        }

        if (totalAmount >= 26) totalAmount -= 26; //last day consumption

        System.out.println(numberOfDays);
        System.out.println(totalAmount);
    }
}
