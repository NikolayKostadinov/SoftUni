package L11WhileLoopLab;

import java.util.Scanner;

public class P06MaxNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int maxNum = Integer.MIN_VALUE;
        while (!text.equalsIgnoreCase("stop")) {
            int num = Integer.parseInt(text);
            if (num > maxNum) maxNum = num;
            text = scan.nextLine();
        }

        System.out.println(maxNum);
    }
}
