package L10ForLoopExercise;

import java.util.Scanner;

public class P05DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double p1 = 0, p2 = 0, p3 = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if (num % 2 == 0) p1++;
            if (num % 3 == 0) p2++;
            if (num % 4 == 0) p3++;
        }

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%",
                (p1 / n) * 100.0,
                (p2 / n) * 100.0,
                (p3 / n) * 100.0);
    }
}
