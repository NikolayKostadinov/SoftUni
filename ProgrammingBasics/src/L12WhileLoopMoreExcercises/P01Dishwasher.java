package L12WhileLoopMoreExcercises;

import java.util.Scanner;

public class P01Dishwasher {
    public static void main(String[] args) {
        int perPlate = 5;
        int perPot = 15;

        Scanner scan = new Scanner(System.in);
        int washerLiquidBottles = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int washerLiquid = 750 * washerLiquidBottles;

        int dishesCount = 0;
        int platesCount = 0;
        int potsCount = 0;
        int washingCount = 0;
        while (!command.equals("End")){
            washingCount++;
            dishesCount = Integer.parseInt(command);
            if (washingCount % 3 == 0){
                potsCount += dishesCount;
                washerLiquid -= (dishesCount * perPot);
            } else {
                platesCount += dishesCount;
                washerLiquid -= (dishesCount * perPlate);
            }

            if (washerLiquid < 0) break;
            command = scan.nextLine();
        }

        if (command.equals("End")){
            System.out.printf("Detergent was enough!\n%d dishes and %d pots were washed.\nLeftover detergent %d ml.",platesCount,potsCount,washerLiquid);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(washerLiquid));
        }
    }
}