package L14NestedLoopsLabExcercises;

import java.util.Scanner;

public class P13PrimePairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min1 = Integer.parseInt(scan.nextLine());
        int min2 = Integer.parseInt(scan.nextLine());
        int delta1 = Integer.parseInt(scan.nextLine());
        int delta2 = Integer.parseInt(scan.nextLine());

        for (int d1 = min1; d1 <= min1 + delta1; d1++) {
            for (int d2 = min2; d2 <= min2 + delta2; d2++) {
                if (isPrime(d1) && isPrime(d2)) System.out.printf("%d%d\n",d1,d2);
            }
        }
    }

    private static boolean isPrime(int num){
        int maxNum = (int) Math.round(Math.sqrt(num));
        for (int i = 2; i <= maxNum ; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
