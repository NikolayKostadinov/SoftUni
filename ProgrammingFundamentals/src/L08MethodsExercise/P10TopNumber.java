package L08MethodsExercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        printTopNumbers(number);
    }

    private static void printTopNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            if (checkTopNumber(i))
                System.out.println(i);
        }
    }

    private static boolean checkTopNumber(int number) {
        int sum = 0;
        boolean hasOddNumber = false;
        while (number > 0) {
            sum += number % 10;
            if ((number % 10) % 2 != 0) {
                hasOddNumber = true;
            }
            number /= 10;
        }

        return sum % 8 == 0 && hasOddNumber;
    }
}
