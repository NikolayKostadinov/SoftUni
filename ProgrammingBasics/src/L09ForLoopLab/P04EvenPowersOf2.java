package L09ForLoopLab;

import java.util.Scanner;

public class P04EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        n = n - (n % 2);
        for (int i = 0; i <= n; i+=2) {
            System.out.println((int)Math.pow(2,i));
        }
    }
}
