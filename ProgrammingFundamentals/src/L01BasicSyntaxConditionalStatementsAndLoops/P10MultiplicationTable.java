package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        int multiplier = 1;
        while (multiplier <= 10){
            System.out.printf("%d X %d = %d\n", number, multiplier,number * multiplier++);
        }
    }
}
