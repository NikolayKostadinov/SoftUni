package L07ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P06NumberInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double number = Double.parseDouble(scan.nextLine());

        System.out.println((-100 <= number && number <= 100 && number != 0) ? "Yes" : "No");
    }
}