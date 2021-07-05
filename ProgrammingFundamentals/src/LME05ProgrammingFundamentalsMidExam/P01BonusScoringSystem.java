package LME05ProgrammingFundamentalsMidExam;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scan.nextLine());
        int lecturesCount = Integer.parseInt(scan.nextLine());
        int additionalBonus = Integer.parseInt(scan.nextLine());

        double maxBonus = 0.0;
        int attended = 0;

        for (int i = 0; i < studentsCount; i++) {
            int attendances = Integer.parseInt(scan.nextLine());

            double currentBonus = attendances/(double)lecturesCount * (5 + additionalBonus);
            if (currentBonus > maxBonus){
                maxBonus = currentBonus;
                attended = attendances;
            }
        }

        System.out.printf("Max Bonus: %d.\n", (int)Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", attended);
    }
}
