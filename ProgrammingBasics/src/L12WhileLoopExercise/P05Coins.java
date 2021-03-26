package L12WhileLoopExercise;

import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tip = Double.parseDouble(scan.nextLine());
        double reminder = tip;
        double[] val = {1,0.5,0.2,0.1,0.05, 0.02, 0.01};
        int valIx = 0;
        int count = 0;
        double difference = 0;
        while (reminder != 0){
            difference = Math.round((reminder - val[valIx]) * 100) / 100;
            if ( difference >= 0){
                count++;
                reminder = difference;
            } else {
                valIx++;
            }
        }

        System.out.println(count);
    }
}
