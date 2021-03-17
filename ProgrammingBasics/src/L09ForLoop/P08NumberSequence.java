package L09ForLoop;

import java.util.Scanner;

public class P08NumberSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int min = 0;
        int max = 0;

        if (n > 0) {
            min = max = Integer.parseInt(scan.nextLine());
            for (int i = 1; i < n; i++) {
                int num = Integer.parseInt(scan.nextLine());
                if (num < min) min = num;
                if (num > max) max = num;
            }
        }

        System.out.printf("Max number: %d%nMin number: %d", max, min);
    }
}
