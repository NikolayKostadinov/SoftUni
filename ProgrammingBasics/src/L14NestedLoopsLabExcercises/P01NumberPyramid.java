package L14NestedLoopsLabExcercises;

import java.util.Scanner;

public class P01NumberPyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                num++;
                System.out.printf("%d ",num);
                if(num==n) return;
            }
            System.out.println();
        }
    }
}