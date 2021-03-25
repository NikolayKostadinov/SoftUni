package L11WhileLoopLab;

import java.util.Scanner;

public class P07MinNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int minNum = Integer.MAX_VALUE;
        while (!text.equalsIgnoreCase("stop")) {
            int num = Integer.parseInt(text);
            if (num < minNum) minNum = num;
            text = scan.nextLine();
        }

        System.out.println(minNum);
    }
}
