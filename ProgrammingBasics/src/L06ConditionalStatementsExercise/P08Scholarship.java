package L06ConditionalStatementsExercise;

import java.util.Scanner;

public class P08Scholarship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double income = Double.parseDouble(scan.nextLine());
        double averageGrade = Double.parseDouble(scan.nextLine());
        double minSalary = Double.parseDouble(scan.nextLine());

        double gradeScholarship = 0;
        if (averageGrade >= 5.5) {
            gradeScholarship = averageGrade * 25.0;
        }

        double socialScholarship = 0;
        if (minSalary > income && averageGrade > 4.5) {
            socialScholarship = minSalary * 0.35 ;
        }

        if (socialScholarship == 0 && gradeScholarship == 0) {
            System.out.println("You cannot get a scholarship!");
        } else if (socialScholarship > gradeScholarship) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
        } else {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(gradeScholarship));
        }
    }
}
