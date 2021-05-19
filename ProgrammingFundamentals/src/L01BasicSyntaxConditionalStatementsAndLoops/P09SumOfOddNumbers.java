package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int odd = (i * 2) - 1;
            System.out.println(odd);
            sum += odd;
        }

        System.out.printf("Sum: %d", sum);
    }
}
