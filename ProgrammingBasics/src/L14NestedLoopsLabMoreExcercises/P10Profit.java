package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P10Profit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max1 = Integer.parseInt(scan.nextLine());
        int max2 = Integer.parseInt(scan.nextLine());
        int max5 = Integer.parseInt(scan.nextLine());
        int sum = Integer.parseInt(scan.nextLine());

        for (int count1 = 0; count1 <= max1 ; count1++) {
            for (int count2 = 0; count2 <= max2; count2++) {
                for (int count5 = 0; count5 <= max5; count5++) {
                    if (count1 + count2 * 2 + count5 * 5 == sum)
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.\n", count1, count2, count5, sum);
                }
            }
        }
    }
}
