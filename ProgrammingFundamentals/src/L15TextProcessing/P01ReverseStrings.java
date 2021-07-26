package L15TextProcessing;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        while (!"end".equals(command)) {
            System.out.printf("%s = %s\n", command, reverseWord(command));
            command = scan.nextLine();
        }
    }

    private static String reverseWord(String command) {
        char[] letters = command.toCharArray();
        StringBuilder sb = new StringBuilder(letters.length);
        for (int i = letters.length - 1; i >= 0; i--) {
            sb.append(letters[i]);
        }
        return sb.toString();
    }
}
