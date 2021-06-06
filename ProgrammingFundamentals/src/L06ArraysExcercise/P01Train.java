package L06ArraysExcercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wagonsNumber = Integer.parseInt(scan.nextLine());
        int[] wagons = new int[wagonsNumber];
        int sum = 0;
        for (int i = 0; i < wagonsNumber; i++) {
            int peoplesCount = Integer.parseInt(scan.nextLine());
            sum += peoplesCount;
            wagons[i] = peoplesCount;
        }

        for (int wagon:wagons) {
            System.out.printf("%d ", wagon);
        }
        System.out.println();
        System.out.println(sum);
    }
}
