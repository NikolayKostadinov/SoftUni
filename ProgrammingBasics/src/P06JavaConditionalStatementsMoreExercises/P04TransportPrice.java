package P06JavaConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P04TransportPrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int distance = Integer.parseInt(scan.nextLine());
        String time = scan.nextLine();

        double taxiPrice =  0.7 + ((time.equalsIgnoreCase("day")) ? 0.79 * distance : 0.9 * distance);
        double busPrice = (distance >= 20) ? distance * 0.09 : taxiPrice + 1;
        double trainPrice = (distance >= 100) ? distance * 0.06 : taxiPrice + 1;

        System.out.printf("%.2f", Math.min(taxiPrice, Math.min(busPrice, trainPrice)));
    }
}
