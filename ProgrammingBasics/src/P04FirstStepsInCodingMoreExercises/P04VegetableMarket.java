package P04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P04VegetableMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double vegetablesPrice = Double.parseDouble(scan.nextLine());
        double fruitPrice = Double.parseDouble(scan.nextLine());
        int vegetablesWeight = Integer.parseInt(scan.nextLine());
        int fruitWeight = Integer.parseInt(scan.nextLine());

        double priceInLv = vegetablesPrice * vegetablesWeight + fruitPrice * fruitWeight;
        double priceInEur = priceInLv / 1.94;

        System.out.printf("%.2f", priceInEur);
    }
}
