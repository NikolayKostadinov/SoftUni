package L07Methods;

import java.util.Scanner;

public class P02Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = Double.parseDouble(scan.nextLine());
        printGrade(grade);
    }

    private static void printGrade(double grade) {
        String gradeText = "";
        if (2.00 <= grade && grade < 3.00) gradeText = "Fail";
        else if (3.00 <= grade && grade < 3.50) gradeText = "Poor";
        else if (3.50 <= grade && grade < 4.50) gradeText = "Good";
        else if (4.50 <= grade && grade < 5.50) gradeText = "Very good";
        else if (5.50 <= grade) gradeText = "Excellent";
        System.out.println(gradeText);
    }

}
