package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P01UniquePINCodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxN1 = Integer.parseInt(scan.nextLine());
        int maxN2 = Integer.parseInt(scan.nextLine());
        int maxN3 = Integer.parseInt(scan.nextLine());

        if (maxN2 > 7) maxN2 = 7;

        for (int n1 = 2; n1 <= maxN1; n1 += 2) {
            for (int n2 = 2; n2 <= maxN2; n2++) {
                if (IsSimple(n2)){
                    for (int n3 = 2; n3 <= maxN3; n3+=2) {
                        System.out.printf("%d %d %d\n", n1, n2, n3);
                    }
                }
            }
        }
    }

    private static boolean IsSimple(int n) {
        int to = (int)Math.round(Math.sqrt(n));
        for (int i = 2; i <= to; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
