package L13NestedLoopsLab;

import java.util.Scanner;

public class P04SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = Integer.parseInt(scan.nextLine());
        int max = Integer.parseInt(scan.nextLine());
        int num = Integer.parseInt(scan.nextLine());
        int combCount = 0;

        for (int i = min; i <= max ; i++) {
            for (int j = min; j <= max ; j++) {
                combCount ++;
                if (i + j == num){
                    System.out.printf("Combination N:%d (%d + %d = %d)", combCount, i, j, i+j);
                    return;
                }
            }
        }

        System.out.printf("%d combinations - neither equals %d", combCount, num);

    }
}
