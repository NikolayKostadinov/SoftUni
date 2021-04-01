package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P08SecretDoorsLock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max100 = Integer.parseInt(scan.nextLine());
        int max10 = Integer.parseInt(scan.nextLine());
        int max1 = Integer.parseInt(scan.nextLine());

        if (max10 > 7) max10 = 7;

        for (int p100 = 1; p100 <= max100; p100++) {
            for (int p10 = 2; p10 <= max10; p10++) {
                for (int p1 = 1; p1 <= max1; p1++) {
                    if (p100 % 2 == 0 && p1 % 2 == 0 && isSimple(p10)){
                        System.out.printf("%d %d %d\n", p100, p10, p1);
                    }
                }
            }
        }
    }

    private static boolean isSimple(final int n) {
        int to = (int) Math.round(Math.sqrt(n));
        for (int i = 2; i <= to; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
