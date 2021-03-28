package L12WhileLoopExercise;

import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tip = Math.round(Double.parseDouble(scan.nextLine()) * 100);
        double reminder = tip;
        double[] val = {200,100,50,20,10,5, 2, 1};
        int valIx = 0;
        int count = 0;
        while (reminder != 0){
            if (  reminder - val[valIx] >= 0){
                count++;
                reminder -= val[valIx];
            } else {
                valIx++;
            }
        }

        System.out.println(count);
    }
}
