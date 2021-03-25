package L11WhileLoopLab;

import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = Integer.parseInt(scan.nextLine());
        int sum = Integer.parseInt(scan.nextLine());

        while (sum < max) {
            sum += Integer.parseInt(scan.nextLine());
        }

        System.out.println(sum);
    }
}
