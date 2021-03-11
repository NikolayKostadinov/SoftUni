package L07ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P10InvalidNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double number = Double.parseDouble(scan.nextLine());

        if(!((100 <= number && number <= 200) || number == 0)) {
            System.out.println("invalid");
        }
    }
}

