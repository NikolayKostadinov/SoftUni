package L04FirstStepsInCodingExercise;

import java.util.Scanner;

public class P06CharityCampaign {
    // constants
    private static final double cakePrice  = 45;
    private static final double wafflePrice = 5.8;
    private static final double pancakePrice  = 3.2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short campaignDays = Short.parseShort(sc.nextLine());
        short chefsCount = Short.parseShort(sc.nextLine());
        short cakeCount = Short.parseShort(sc.nextLine());
        short wafflesCount = Short.parseShort(sc.nextLine());
        short pancakesCount = Short.parseShort(sc.nextLine());

        double sum = (cakeCount * cakePrice + wafflesCount * wafflePrice + pancakesCount * pancakePrice) * chefsCount * campaignDays;
        sum = sum - (sum / 8.0);

        System.out.printf("%.2f", sum);
    }
}
