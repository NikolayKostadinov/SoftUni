package L09ForLoopLab;

import java.util.Scanner;

public class P09LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int lSum = 0;
        int rSum = 0;
        for (int i = 0; i < n * 2; i++) {
            if (i < n) {
                lSum += Integer.parseInt(scan.nextLine());
            } else {
                rSum += Integer.parseInt(scan.nextLine());
            }
        }

        if (lSum == rSum) {
            System.out.printf("Yes, sum = %d", lSum);
        } else {
            System.out.printf("No, diff = %d", Math.abs(lSum - rSum));
        }
    }
}
