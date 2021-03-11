package L05ConditionalStatements;

import java.util.Scanner;

public class P04Number100And200 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());

        if (num1 < 100) {
            System.out.println("Less than 100");
        } else if (num1 >= 100 && num1 <= 200) {
            System.out.println("Between 100 and 200");
        } else {
            System.out.println("Greater than 200");
        }
    }
}
