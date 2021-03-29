package L12WhileLoopMoreExcercises;

import java.util.Scanner;

public class P05AverageNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int i = 0;
        int sum = 0;
        while (i<n){
            sum += Integer.parseInt(scan.nextLine());
            i++;
        }

        System.out.printf("%.2f", sum / (double)n);
    }
}
