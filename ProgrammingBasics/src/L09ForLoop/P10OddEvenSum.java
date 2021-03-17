package L09ForLoop;

import java.util.Scanner;

public class P10OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < n ; i++){
            if (i%2 == 0){
                sumEven += Integer.parseInt(scan.nextLine());
            } else {
                sumOdd += Integer.parseInt(scan.nextLine());
            }
        }

        if (sumEven == sumOdd){
            System.out.printf("Yes\nSum = %d\n", sumEven);
        } else {
            System.out.printf("No\nDiff = %d\n", (int)Math.abs(sumEven-sumOdd));
        }
    }
}
