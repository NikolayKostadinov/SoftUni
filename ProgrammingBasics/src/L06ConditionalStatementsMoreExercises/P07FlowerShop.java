package L06ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P07FlowerShop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double magnoliaPrice = 3.25;
        double hyacinthPrice = 4;
        double rosePrice = 3.50;
        double cactusPrice = 8;

        int magnoliaCount = Integer.parseInt(scan.nextLine());
        int hyacinthCount = Integer.parseInt(scan.nextLine());
        int rosesCount = Integer.parseInt(scan.nextLine());
        int cactiCount = Integer.parseInt(scan.nextLine());
        double presentPrice = Double.parseDouble(scan.nextLine());

        double profit = ((magnoliaCount * magnoliaPrice)
                + (hyacinthCount * hyacinthPrice)
                + (rosesCount * rosePrice)
                + (cactiCount * cactusPrice)) * 0.95;

        double difference = Math.abs(presentPrice - profit);

        if (profit >= presentPrice){
            System.out.printf("She is left with %.0f leva.", Math.floor(difference));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(difference));
        }
    }
}
