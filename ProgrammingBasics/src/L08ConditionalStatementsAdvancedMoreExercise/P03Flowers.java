package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P03Flowers {
    public static void main(String[] args) {
//chrysanthemums, roses and tulips
        Scanner scan = new Scanner(System.in);

        int chrysanthemumsCount = Integer.parseInt(scan.nextLine());
        int rosesCount = Integer.parseInt(scan.nextLine());
        int tulipsCount = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        String isHoliday = scan.nextLine();

        double flowersPrice = 0;
        switch (season) {
            case "Spring":
            case "Summer":
                    flowersPrice = chrysanthemumsCount * 2
                            + rosesCount * 4.10
                            + tulipsCount * 2.50;
                break;
            case "Autumn":
            case "Winter":
                flowersPrice = chrysanthemumsCount * 3.75
                        + rosesCount * 4.50
                        + tulipsCount * 4.15;
                break;
        }

        if (isHoliday.equalsIgnoreCase("y")) flowersPrice *= 1.15;
        if (tulipsCount > 7 && season.equalsIgnoreCase("spring")) flowersPrice *= 0.95;
        if (rosesCount >= 10 && season.equalsIgnoreCase("winter")) flowersPrice *= 0.90;
        if (chrysanthemumsCount + rosesCount + tulipsCount > 20) flowersPrice *= 0.8;

        flowersPrice += 2;

        System.out.printf("%.2f", flowersPrice);
    }
}
