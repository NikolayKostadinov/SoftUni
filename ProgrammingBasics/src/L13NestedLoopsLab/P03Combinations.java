package L13NestedLoopsLab;

import java.util.Scanner;

public class P03Combinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int solveCount = 0;
        for (int x1 = 0; x1 <= n; x1++) {
            for (int x2 = 0; x2 <= n; x2++) {
                for (int x3 = 0; x3 <= n; x3++) {
                    if (x1 + x2 + x3 == n) solveCount++;
                }
            }
        }

        System.out.println(solveCount);
    }
}
