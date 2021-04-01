package L15DrawingFiguresWithLoops;

import java.util.Scanner;

public class P07ChristmasTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int row = 0; row < n + 1; row++) {
            for (int i = 0; i < n-row; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < row; i++) {
                System.out.print("*");
            }
            System.out.print(" | ");

            for (int i = 0; i < row; i++) {
                System.out.print("*");
            }
            for (int i = 0; i <= n-row; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
