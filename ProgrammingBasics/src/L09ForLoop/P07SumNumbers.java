package L09ForLoop;

import java.util.Scanner;

public class P07SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(scan.nextLine());
        }

        System.out.println(sum);
    }
}
