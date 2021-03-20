package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P02BikeRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int juniorsCount = Integer.parseInt(scan.nextLine());
        int seniorsCount = Integer.parseInt(scan.nextLine());
        String truck = scan.nextLine();

        double competitionPrice = 0;
        switch (truck){
            case "trail":
                competitionPrice = juniorsCount * 5.5 + seniorsCount * 7.0;
                break;
            case "cross-country":
                competitionPrice = juniorsCount * 8.0 + seniorsCount * 9.5;
                if (juniorsCount + seniorsCount >= 50) competitionPrice *= 0.75;
                break;
            case "downhill":
                competitionPrice = juniorsCount * 12.25 + seniorsCount * 13.75;
                break;
            case "road":
                competitionPrice = juniorsCount * 20 + seniorsCount * 21.5;
                break;
        }

        System.out.printf("%.2f", competitionPrice * 0.95);


    }
}
