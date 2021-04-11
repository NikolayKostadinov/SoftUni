package L16SapleExams.ProgrammingBasicsOnlineRetakeExam2and3May2019;

import java.util.Scanner;

public class P05DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        int p1=0, p2=0, p3=0;
        int number;
        for (int i = 0; i < count; i++) {
            number = Integer.parseInt(scan.nextLine());
            if (number % 2 == 0 ) p1++;
            if (number % 3 == 0) p2++;
            if (number % 4 == 0) p3++;
        }

        System.out.printf("%.2f%%\n", (p1 / (double) count) * 100.0);
        System.out.printf("%.2f%%\n", (p2 / (double) count) * 100.0);
        System.out.printf("%.2f%%\n", (p3 / (double) count) * 100.0);

    }
}
