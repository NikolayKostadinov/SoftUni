package L03DataTypesAndVariables;

import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumOfDigits = 0;
        for (int number = 1; number <= n; number++) {
            int copyOfNumber = number;
            while (number > 0) {
                sumOfDigits += number % 10;
                number = number / 10;
            }

            System.out.printf("%d -> %s%n", copyOfNumber,
                    ((sumOfDigits == 5) || (sumOfDigits == 7) || (sumOfDigits == 11)) ? "True" : "False");
            sumOfDigits = 0;
            number = copyOfNumber;
        }
    }
}
