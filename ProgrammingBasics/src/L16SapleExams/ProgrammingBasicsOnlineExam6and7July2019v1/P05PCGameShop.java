package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v1;

import java.util.Scanner;

public class P05PCGameShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int gamesCount = Integer.parseInt(scan.nextLine());

        int	countHearthstone = 0;
        int	countFornite = 0;
        int	countOverwatch = 0;
        int	countOthers = 0;

        for (int i = 0; i < gamesCount; i++) {
            switch (scan.nextLine()){
                case "Hearthstone":
                    countHearthstone++;
                    break;
                case "Fornite":
                    countFornite++;
                    break;
                case "Overwatch":
                    countOverwatch++;
                    break;
                default:
                    countOthers++;
                    break;
            }
        }

        int sumCount = countFornite + countHearthstone + countOverwatch + countOthers;

        System.out.printf("Hearthstone - %.2f%%\n", (countHearthstone / (double)sumCount) * 100.0);
        System.out.printf("Fornite - %.2f%%\n", (countFornite / (double)sumCount) * 100.0);
        System.out.printf("Overwatch - %.2f%%\n", (countOverwatch / (double)sumCount) * 100.0);
        System.out.printf("Others - %.2f%%\n", (countOthers / (double)sumCount) * 100.0);
    }
}
