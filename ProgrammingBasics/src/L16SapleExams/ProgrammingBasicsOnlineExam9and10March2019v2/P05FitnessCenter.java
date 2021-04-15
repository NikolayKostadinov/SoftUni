package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v2;

import java.util.Scanner;

public class P05FitnessCenter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int clientCount = Integer.parseInt(scan.nextLine());
        int countBack = 0;
        int countChest = 0;
        int countLegs = 0;
        int countAbs = 0;
        int countProteinShake = 0;
        int countProteinBar = 0;

        for (int i = 0; i < clientCount; i++) {
            switch (scan.nextLine()) {
                case "Back":
                    countBack++;
                    break;
                case "Chest":
                    countChest++;
                    break;
                case "Legs":
                    countLegs++;
                    break;
                case "Abs":
                    countAbs++;
                    break;
                case "Protein shake":
                    countProteinShake++;
                    break;
                case "Protein bar":
                    countProteinBar++;
                    break;
            }
        }

        System.out.printf("%d - back\n", countBack);
        System.out.printf("%d - chest\n", countChest);
        System.out.printf("%d - legs\n", countLegs);
        System.out.printf("%d - abs\n", countAbs);
        System.out.printf("%d - protein shake\n", countProteinShake);
        System.out.printf("%d - protein bar\n", countProteinBar);
        System.out.printf("%.2f%% - work out\n", (countBack + countChest + countLegs + countAbs) * 100 / (double) clientCount);
        System.out.printf("%.2f%% - protein\n", (countProteinShake + countProteinBar) * 100 / (double) clientCount);

    }
}
