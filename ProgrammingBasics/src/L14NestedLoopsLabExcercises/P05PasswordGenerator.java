package L14NestedLoopsLabExcercises;

import java.util.Scanner;

public class P05PasswordGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int p1 = 1; p1 <= n; p1++) {
            for (int p2 = 1; p2 <= n; p2++) {
                for (int p3 = 0; p3 < l; p3++) {
                    for (int p4 = 0; p4 < l; p4++) {
                        for (int p5 = (p1 > p2) ? p1 + 1 : p2 + 1; p5 <= n; p5++) {
                            System.out.printf("%d%d%s%s%d ", p1, p2, alphabet.charAt(p3), alphabet.charAt(p4), p5);
                        }
                    }
                }
            }
        }
    }
}
