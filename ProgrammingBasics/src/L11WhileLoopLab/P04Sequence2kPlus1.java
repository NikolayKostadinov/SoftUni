package L11WhileLoopLab;

import java.util.Scanner;

public class P04Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int num = 1;
        while (num <= n){
            System.out.println(num);
            num = num * 2 + 1;
        }
    }
}
