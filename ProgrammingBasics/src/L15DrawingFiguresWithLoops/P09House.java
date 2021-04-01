package L15DrawingFiguresWithLoops;

import java.util.Scanner;

public class P09House {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int n = Integer.parseInt(scan.nextLine());
            for (int i = 1; i <= (n + 1) / 2; i++) {
                for (int j = 1; j <= (n + 1) / 2 - i; j++) {
                    System.out.print("-");
                }

                for (int j = 0; j < ((n % 2 == 0) ? 2 : 1) + (i - 1) * 2; j++) {
                    System.out.print("*");
                }

                for (int j = 1; j <= (n + 1) / 2 - i; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }

            for (int i = 1; i <= n / 2; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j == 1 || j == n) System.out.print("|");
                    else System.out.print("*");
                }
                System.out.println();
            }

        }
    }
}
