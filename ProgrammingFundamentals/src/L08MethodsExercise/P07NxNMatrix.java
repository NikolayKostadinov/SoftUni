package L08MethodsExercise;

import java.util.Scanner;

public class P07NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        printMatrix(number);
    }

    private static void printMatrix(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.printf("%d ",number);
            }
            System.out.println();
        }
    }
}
