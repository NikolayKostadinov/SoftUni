package L06ArraysMoreExcercise;

import java.util.Arrays;
import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int [] lastRow = new int[]{1};

        for (int i = 2; i <= n; i++) {
            int[] row = new int[i];
            for (int j = 0; j < row.length; j++) {
                int m1 = (j-1 < 0) ? 0 : lastRow[j-1];
                int m2 = (j > lastRow.length - 1)? 0 : lastRow[j];
                row[j] = m1 + m2;
            }
            Arrays.stream(lastRow).forEach(x-> System.out.printf("%d ",x));
            System.out.println();
            lastRow = row;
        }
        Arrays.stream(lastRow).forEach(x-> System.out.printf("%d ",x));
        System.out.println();
    }
}
