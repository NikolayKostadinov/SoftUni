package L10ForLoopExercise;

import java.util.Scanner;

public class P02HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int maxElement = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(scan.nextLine());
            sum += element;
            if (maxElement < element) {
                maxElement = element;
            }
        }

        if (sum - maxElement == maxElement) {
            System.out.printf("Yes\nSum = %d", maxElement);
        } else {
            System.out.printf("No\nDiff = %d", (int) Math.abs(sum - maxElement * 2));
        }
    }
}
