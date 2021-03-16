package L08ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        String operation = scan.nextLine();

        double result = 0;
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 != 0) {
                    result = (double) number1 / number2;
                    System.out.printf("%d / %d = %.2f", number1, number2, result);
                } else {
                    System.out.printf("Cannot divide %d by zero", number1);
                }
                break;
            case "%":
                if (number2 != 0) {
                    result = number1 % number2;
                    System.out.printf("%d %% %d = %.0f", number1, number2, result);
                } else {
                    System.out.printf("Cannot divide %d by zero", number1);
                }
                break;
        }

        if (operation.equalsIgnoreCase("+")
                || operation.equalsIgnoreCase("-")
                || operation.equalsIgnoreCase("*")) {
            System.out.printf("%d %s %d = %.0f - %s", number1, operation, number2, result, (result % 2 == 0) ? "even" : "odd");
        }
    }
}
