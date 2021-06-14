package L07Methods;

import java.util.Scanner;

public class P01SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        printSign(number);
    }

    private static void printSign(int number) {
        String sign = "";
        if (number > 0) sign = "positive";
        else if (number < 0) sign = "negative";
        else sign = "zero";

        System.out.printf("The number %d is %s.", number, sign);
    }
}
