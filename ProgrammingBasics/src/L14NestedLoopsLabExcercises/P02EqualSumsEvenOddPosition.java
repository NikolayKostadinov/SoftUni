package L14NestedLoopsLabExcercises;

import java.util.Scanner;

public class P02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = Integer.parseInt(scan.nextLine());
        int max = Integer.parseInt(scan.nextLine());
        String stringNum;
        for (Integer i = min; i <= max ; i++) {
            int sumEven = 0;
            int sumOdd = 0;
            stringNum = i.toString();
            for (int j = 0; j < 6; j++) {
                int num = Integer.parseInt(String.valueOf(stringNum.charAt(j)));
                if ((j + 1) % 2 == 0)
                {
                    sumEven += num;
                } else {
                    sumOdd += num;
                }
            }

            if (sumEven == sumOdd) System.out.printf("%d ", i);
        }
    }
}
