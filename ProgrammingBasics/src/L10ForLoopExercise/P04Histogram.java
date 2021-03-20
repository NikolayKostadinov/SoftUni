package L10ForLoopExercise;

import java.util.Scanner;

public class P04Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if (num < 200) p1++;
            else if (200 <= num && num <= 399) p2++;
            else if (400 <= num && num <= 599) p3++;
            else if (600 <= num && num <= 799) p4++;
            else if (800 <= num) p5++;
        }

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n",
                (p1 / n) * 100.0,
                (p2 / n) * 100.0,
                (p3 / n) * 100.0,
                (p4 / n) * 100.0,
                (p5 / n) * 100.0);
    }
}
