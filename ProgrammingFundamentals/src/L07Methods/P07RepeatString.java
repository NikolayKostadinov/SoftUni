package L07Methods;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int times = Integer.parseInt(scan.nextLine());
        String result = duplicateString(input, times);

        System.out.println(result);
    }

    private static String duplicateString(String input, int times) {
        StringBuilder sb = new StringBuilder(input.length() * times);
        for (int i = 0; i < times; i++) {
            sb.append(input);
        }
        return sb.toString();
    }
}
