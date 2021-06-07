package L04DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P04SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int asciiSum = 0;
        for (int i = 0; i < n; i++) {
            asciiSum += scan.nextLine().charAt(0);
        }

        System.out.printf("The sum equals: %d", asciiSum);
    }
}
