package L10ForLoopMoreExercises;

import java.util.Scanner;

public class P08EqualPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCount = Integer.parseInt(scan.nextLine());

        int prevSum = 0;
        int maxDiff = Integer.MIN_VALUE;
        boolean allEqual = true;
        for (int i = 0; i < numCount; i++) {
            int currentSum = Integer.parseInt(scan.nextLine());
            currentSum += Integer.parseInt(scan.nextLine());

            if (i > 0) {
                allEqual = currentSum == prevSum;
                int difference = Math.abs(prevSum - currentSum);
                if (difference > maxDiff) maxDiff = difference;
            }

            prevSum = currentSum;
        }

        if (allEqual) {
            System.out.printf("Yes, value=%d", prevSum);
        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}

