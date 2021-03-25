package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P10MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());

        while (num >= 0){
            System.out.printf("Result: %.2f\n", num * 2.0);
            num = Double.parseDouble(scan.nextLine());
        }

        System.out.println("Negative number!");
    }
}
