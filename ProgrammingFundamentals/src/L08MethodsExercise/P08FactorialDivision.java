package L08MethodsExercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        printDivision(fac(a), fac(b));
    }

    private static void printDivision(double num1, double num2) {
        System.out.printf("%.2f", num1 / num2);
    }

    private static double fac(int num) {
        double result = 1;

        if (num > 1) {
            for (int i = num; i > 1; i--) {
                result *= i;
            }
        }

        return result;
    }
}
