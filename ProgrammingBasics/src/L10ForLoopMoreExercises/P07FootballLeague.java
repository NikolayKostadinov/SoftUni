package L10ForLoopMoreExercises;

import java.util.Scanner;

public class P07FootballLeague {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scan.nextLine());
        int fensCount = Integer.parseInt(scan.nextLine());
        int countA = 0;
        int countB = 0;
        int countV = 0;
        int countG = 0;

        for (int i = 0; i < fensCount; i++) {
            switch (scan.nextLine()) {
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "V":
                    countV++;
                    break;
                case "G":
                    countG++;
                    break;
            }
        }

        System.out.printf("%.2f%%\n", (countA / (double) fensCount) * 100);
        System.out.printf("%.2f%%\n", (countB / (double) fensCount) * 100);
        System.out.printf("%.2f%%\n", (countV / (double) fensCount) * 100);
        System.out.printf("%.2f%%\n", (countG / (double) fensCount) * 100);
        System.out.printf("%.2f%%\n", (fensCount / (double) stadiumCapacity) * 100);
    }
}
