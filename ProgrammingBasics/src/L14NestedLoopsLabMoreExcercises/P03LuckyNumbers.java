package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P03LuckyNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int p1 = 1; p1 <= 9; p1++) {
            for (int p2 = 1; p2 <= 9; p2++) {
                for (int p3 = 1; p3 <= 9; p3++) {
                    for (int p4 = 1; p4 <= 9; p4++) {
                        if(p1 + p2 == p3 + p4 && n % (p1 + p2) == 0){
                            System.out.printf("%d%d%d%d ", p1, p2, p3, p4);
                        }
                    }
                }
            }

        }
    }
}
