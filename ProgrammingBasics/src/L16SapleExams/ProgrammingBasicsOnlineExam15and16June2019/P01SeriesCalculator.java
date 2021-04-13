package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class P01SeriesCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String serialName = scan.nextLine();
        int seasonsCount = Integer.parseInt(scan.nextLine());
        int episodesPerSeasonCount = Integer.parseInt(scan.nextLine());
        double episodeClearTime = Double.parseDouble(scan.nextLine());

        double totalLength = ((episodeClearTime * 1.2) * episodesPerSeasonCount + 10.0) * seasonsCount;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", serialName, Math.floor(totalLength));
    }
}
