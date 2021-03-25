package L10ForLoopMoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scan.nextLine());
        double gradesSum = 0;
        int gradesCount2 = 0,
                gradesCount3 = 0,
                gradesCount4 = 0,
                gradesCount5 = 0;

        for (int i = 0; i < studentsCount; i++) {
            double grade = Double.parseDouble(scan.nextLine());
            gradesSum += grade;
            if (2 <= grade && grade <= 2.99) {
                gradesCount2+=1;
            } else if (3 <= grade && grade <= 3.99) {
                gradesCount3 += 1;
            } else if (4 <= grade && grade <= 4.99) {
                gradesCount4 += 1;
            } else if (5 <= grade) {
                gradesCount5 += 1;
            }
        }

        System.out.printf("Top students: %.2f%%\n", (gradesCount5 / (double)studentsCount) * 100.0);
        System.out.printf("Between 4.00 and 4.99: %.2f%%\n", (gradesCount4 / (double)studentsCount) * 100.0);
        System.out.printf("Between 3.00 and 3.99: %.2f%%\n", (gradesCount3 / (double)studentsCount) * 100.0);
        System.out.printf("Fail: %.2f%%\n", (gradesCount2 / (double)studentsCount) * 100.0);
        System.out.printf("Average: %.2f\n", gradesSum / (double)studentsCount);
    }
}
