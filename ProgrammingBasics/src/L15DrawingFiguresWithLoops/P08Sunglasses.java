package L15DrawingFiguresWithLoops;

import java.util.Scanner;

public class P08Sunglasses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n){
                for (int j = 1; j <= n * 2; j++) {
                    System.out.print("*");
                }
                for (int j = 1; j <= n; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= n * 2; j++) {
                    System.out.print("*");
                }
            } else {
                System.out.print("*");
                for (int j = 1; j <= n * 2 - 2; j++) {
                    System.out.print("/");
                }
                System.out.print("*");
                for (int j = 1; j <= n; j++) {
                    if (Math.ceil(n / 2.0) == i ){
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("*");
                for (int j = 0; j < n * 2 - 2; j++) {
                    System.out.print("/");
                }
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
