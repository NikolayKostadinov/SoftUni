package L07Methods;

import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        String operation = scan.nextLine();
        int b = Integer.parseInt(scan.nextLine());

        System.out.printf("%d", calculate(a, operation, b));
    }

    private static int calculate(int a, String operation, int b) {
        int result = 0;

        switch (operation) {
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
        }

        return result;
    }
}
