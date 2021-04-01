package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P04CarNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int minNum = Integer.parseInt(scan.nextLine());
        int maxNum = Integer.parseInt(scan.nextLine());

        for (int p1 = minNum; p1 <= maxNum; p1++) {
            for (int p2 = minNum; p2 <= maxNum; p2++) {
                for (int p3 = minNum; p3 <= maxNum; p3++) {
                    for (int p4 = minNum; p4 <= maxNum; p4++) {
                        if (((p1 % 2 == 0 && p4 % 2 != 0) || (p4 % 2 == 0 && p1 % 2 != 0))
                                && (p1 > p4)
                                && ((p2 + p3) % 2 == 0)) {
                            System.out.printf("%d%d%d%d ", p1, p2, p3, p4);
                        }
                    }
                }
            }
        }
    }
}
