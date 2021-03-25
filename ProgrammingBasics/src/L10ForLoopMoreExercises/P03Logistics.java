package L10ForLoopMoreExercises;

import java.util.Scanner;

public class P03Logistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int goodsCount = Integer.parseInt(scan.nextLine());

        double busWeight = 0;
        double truckWeight = 0;
        double trainWeight = 0;

        for (int i = 0; i < goodsCount; i++) {
            int goodWeight = Integer.parseInt(scan.nextLine());
            if (goodWeight <= 3){
                busWeight += goodWeight;
            } else if(3 < goodWeight && goodWeight <= 11){
                truckWeight += goodWeight;
            } else if (goodWeight > 11) {
                trainWeight += goodWeight;
            }
        }

        double allWeight = busWeight + truckWeight + trainWeight;
        double averagePrice = ((busWeight * 200.0) + (truckWeight * 175) + (trainWeight * 120)) / allWeight;

        System.out.printf("%.2f\n", averagePrice);
        System.out.printf("%.2f%%\n", busWeight / allWeight * 100);
        System.out.printf("%.2f%%\n", truckWeight / allWeight * 100);
        System.out.printf("%.2f%%\n", trainWeight / allWeight * 100);


    }
}
