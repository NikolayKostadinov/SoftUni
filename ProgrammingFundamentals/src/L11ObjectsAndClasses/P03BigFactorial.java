package L11ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class P03BigFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(factorial(n));
    }

    private static BigInteger factorial(int n) {
        if (n == 1) return new BigInteger("1");
        return factorial(n-1).multiply(new BigInteger(String.valueOf(n)));
    }
}
