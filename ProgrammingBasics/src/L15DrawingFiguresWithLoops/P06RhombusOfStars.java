package L15DrawingFiguresWithLoops;

import java.util.Scanner;

public class P06RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int row = 1; row <= n; row++) {
                for (int k = 0; k < n - row; k++) {
                    System.out.print(" ");
                }
                System.out.printf("*");

                for (int j = 1; j < row; j++) {
                    System.out.printf(" *");
                }
            System.out.println();
        }

        for (int row = n-1; row >0; row--) {
            for (int k = 0; k < n - row; k++) {
                System.out.print(" ");
            }
            System.out.printf("*");

            for (int j = 1; j < row; j++) {
                System.out.printf(" *");
            }
            System.out.println();
        }
    }
}
