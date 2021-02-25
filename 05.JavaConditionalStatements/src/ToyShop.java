import java.util.Scanner;

public class ToyShop {
    private static final double puzzlePrice = 2.6;
    private static final double talkingDollPrice = 3;
    private static final double bearPrice = 4.1;
    private static final double minionPrice = 8.2;
    private static final double truckPrice = 2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double excursionPrice = Double.parseDouble(scan.nextLine());
        int puzzlesCount = Integer.parseInt(scan.nextLine());
        int talkingDollsCount = Integer.parseInt(scan.nextLine());
        int bearsCount = Integer.parseInt(scan.nextLine());
        int minionsCount = Integer.parseInt(scan.nextLine());
        int trucksCount = Integer.parseInt(scan.nextLine());

        double price = (puzzlesCount * puzzlePrice)
                + (talkingDollsCount * talkingDollPrice)
                + (bearsCount * bearPrice)
                + (minionsCount * minionPrice)
                + (trucksCount * truckPrice);

        int toysCount = puzzlesCount + talkingDollsCount + bearsCount + minionsCount + trucksCount;

        if (toysCount >= 50) {
            price = price * (1 - 0.25);
        }

        double profit = price * 0.9;

        if (profit >= excursionPrice){
            double moneyLeft = profit - excursionPrice;
            System.out.printf("Yes! %.2f lv left.", moneyLeft);
        } else {
            double moneyNotEnough = excursionPrice - profit;
            System.out.printf("Not enough money! %.2f lv needed.", moneyNotEnough);
        }
    }

}
