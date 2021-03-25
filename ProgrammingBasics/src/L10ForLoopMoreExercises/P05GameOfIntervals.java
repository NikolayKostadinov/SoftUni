package L10ForLoopMoreExercises;

import java.util.Scanner;

public class P05GameOfIntervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        int count0to9 = 0;
        int count10to19 = 0;
        int count20to29 = 0;
        int count30to39 = 0;
        int count40to50 = 0;
        int countInvalid = 0;

        double score = 0;

        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (0 <= number && number <= 9) {
                count0to9++;
                score += number * 0.2;
            } else if (10 <= number && number <= 19) {
                count10to19++;
                score += number * 0.3;
            } else if (20 <= number && number <= 29) {
                count20to29++;
                score += number * 0.4;
            } else if (30 <= number && number <= 39) {
                count30to39++;
                score += 50;
            } else if (40 <= number && number <= 50) {
                count40to50++;
                score += 100;
            } else if (0 > number || number > 50) {
                countInvalid++;
                score /= 2.0;
            }
        }

        System.out.printf("%.2f\n", score);
        System.out.printf("From 0 to 9: %.2f%%\n", (count0to9 / (double)count) * 100);
        System.out.printf("From 10 to 19: %.2f%%\n", (count10to19 / (double)count) * 100);
        System.out.printf("From 20 to 29: %.2f%%\n", (count20to29 / (double)count) * 100);
        System.out.printf("From 30 to 39: %.2f%%\n", (count30to39 / (double)count) * 100);
        System.out.printf("From 40 to 50: %.2f%%\n", (count40to50 / (double)count) * 100);
        System.out.printf("Invalid numbers: %.2f%%\n", (countInvalid / (double)count) * 100);
    }
}
