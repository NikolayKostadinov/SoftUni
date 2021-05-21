package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P12EvenNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean isOdd = true;
        do {
            input = Math.abs(Integer.parseInt(scan.nextLine()));
            isOdd = input % 2 != 0;
            if (isOdd) System.out.println("Please write an even number.");
        } while (isOdd);

        System.out.printf("The number is: %d\n", input);

    }
}
