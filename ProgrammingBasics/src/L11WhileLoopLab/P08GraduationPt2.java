package L11WhileLoopLab;

import java.util.Scanner;

public class P08GraduationPt2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        double grade = Double.parseDouble(scan.nextLine());
        double sumGrade = 0;
        int cls = 1;
        int fails = 0;
        while (true) {
            if (grade >= 4) {
                cls++;
                sumGrade += grade;
            } else {
                fails++;
            }

            if (cls > 12 || fails > 1) break;
            grade = Double.parseDouble(scan.nextLine());
        }

        if (cls >= 12) {
            System.out.printf("%s graduated. Average grade: %.2f", name, sumGrade / 12.0);
        } else {
            System.out.printf("%s has been excluded at %d grade", name, cls);
        }
    }
}
