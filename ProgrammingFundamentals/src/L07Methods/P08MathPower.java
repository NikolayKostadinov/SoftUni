package L07Methods;

import java.math.BigDecimal;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigDecimal number = new BigDecimal(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());

        System.out.println(mathPow(number, power));
    }

    private static BigDecimal mathPow(BigDecimal number, int power) {
        if (power == 1) return number;
        return number.multiply(mathPow(number, power - 1));
    }
}
