package L06ArraysMoreExcercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P03RecursiveFibonacci {
    private static int[] memo = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        memo = new int[n+1];
        System.out.println(fib(n));
    }

    public static int fib(int n) {

        if (n < 0) {
            throw new IllegalArgumentException(
                    "Index was negative. No such thing as a negative index in a series.");

            // base cases
        } else if (n == 0 || n == 1) {
            return n;
        }

        // see if we've already calculated this
        if (memo[n] > 0) {
            //System.out.printf("grabbing memo[%d]\n", n);
            return memo[n];
        }

        //System.out.printf("computing fib(%d)\n", n);
        int result = fib(n - 1) + fib(n - 2);

        // memoize
        memo[n] = result;

        return result;
    }
}
