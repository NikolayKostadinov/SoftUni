package P06JavaConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P06Pets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int foodQuantity = Integer.parseInt(scan.nextLine());
        double dogFood = Double.parseDouble(scan.nextLine());
        double catFood = Double.parseDouble(scan.nextLine());
        double turtleFood = Double.parseDouble(scan.nextLine()) / 1000.0;

        double neededFood = (dogFood + catFood + turtleFood) * days;

        double foodDifference = Math.abs(foodQuantity - neededFood);

        if (neededFood <= foodQuantity) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodDifference));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(foodDifference));
        }

    }
}
