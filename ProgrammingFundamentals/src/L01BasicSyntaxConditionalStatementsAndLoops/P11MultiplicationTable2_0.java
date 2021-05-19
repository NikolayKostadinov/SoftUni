package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P11MultiplicationTable2_0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());

        do {
            System.out.printf("%d X %d = %d\n", number, multiplier, number * multiplier++);
        } while (multiplier <= 10);
    }
}
