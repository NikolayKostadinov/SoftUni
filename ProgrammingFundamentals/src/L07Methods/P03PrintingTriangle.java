package L07Methods;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        printTriangle(size);
    }

    private static void printTriangle(int size) {
        printUpper(size);
        printLower(size);
    }

    private static void printLower(int size) {
        for (int i = size - 1; i > 0 ; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
    }

    private static void printUpper(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
    }
}
