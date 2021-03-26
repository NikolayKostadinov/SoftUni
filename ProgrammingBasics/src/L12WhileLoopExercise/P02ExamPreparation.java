package L12WhileLoopExercise;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class P02ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int poorGradesThreshold = Integer.parseInt(scan.nextLine());
        String testName;
        String lastName = "";
        double grade = 0;
        int poorGrades = 0;
        double gradeSum = 0;
        int gradeCount = 0;

        while (true) {
            testName = scan.nextLine();
            if (testName.equals("Enough")) break;

            grade = Double.parseDouble(scan.nextLine());
            gradeSum += grade;
            gradeCount++;
            poorGrades += (grade <= 4) ? 1 : 0;

            if (poorGrades >= poorGradesThreshold) break;

            lastName = testName;
        }

        if (testName.equals("Enough")) {
            System.out.printf("Average score: %.2f\n", gradeSum / (double) gradeCount);
            System.out.printf("Number of problems: %d\n", gradeCount);
            System.out.printf("Last problem: %s", lastName);
        } else {
            System.out.printf("You need a break, %d poor grades.", poorGrades);
        }

    }
}
