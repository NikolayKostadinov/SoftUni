package L02BasicSyntaxConditionalStatementsAndLoopsExcercise;

import java.util.Scanner;

public class P02Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int[] dividers = new int[]{10, 7, 6, 3, 2};

        for (int i = 0; i < dividers.length; i++) {
            if (number % dividers[i] == 0) {
                System.out.printf("The number is divisible by %d\n", dividers[i]);
                return;
            }
        }

        System.out.println("Not divisible");
    }
}
