package L06ArraysExcercise;

import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[] first = new int[n];
        int[] second = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                first[i] = Integer.parseInt(input[0]);
                second[i] = Integer.parseInt(input[1]);
            } else {
                second[i] = Integer.parseInt(input[0]);
                first[i] = Integer.parseInt(input[1]);
            }
        }

        for (var num : first) {
            System.out.printf("%s ", num);
        }
        System.out.println();
        for (var num : second) {
            System.out.printf("%s ", num);
        }
    }
}
