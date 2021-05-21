package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P03PassedOrFailed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = Double.parseDouble(scan.nextLine());

        if (grade >= 3.0) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
