package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P09SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = Integer.parseInt(scan.nextLine());
        int max = Integer.parseInt(scan.nextLine());
        int number = Integer.parseInt(scan.nextLine());
        int combinationsCount = 0;
        boolean isFound = false;

        for (int i = min; i <= max; i++) {
            for (int j = min; j <= max; j++) {
                combinationsCount++;
                if (i + j == number) {
                    System.out.printf("Combination N:%d (%d + %d = %d)\n", combinationsCount, i, j, number);
                    return;
                }
            }
        }

        System.out.printf("%d combinations - neither equals %d", combinationsCount, number);
    }
}
