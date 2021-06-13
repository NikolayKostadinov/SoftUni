package L07Methods;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        System.out.println(multiplyEvenAndOddNumbers(input));
    }

    private static int multiplyEvenAndOddNumbers(int number) {
        int sumOfEven = sumNumbers(number, true);
        int sumOfOdd = sumNumbers(number, false);

        return sumOfEven * sumOfOdd;
    }

    private static int sumNumbers(int number, boolean isEven) {
        int sum = 0;
        int absNumber = Math.abs(number);
        while (absNumber > 0) {
            int currentNumber = absNumber % 10;
            absNumber /= 10;
            if ((currentNumber % 2 == 0) == isEven) {
                sum += currentNumber;
            }
        }

        return sum;
    }
}
