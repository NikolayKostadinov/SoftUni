package L08MethodsExercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String row = scan.nextLine();
        while (!row.equals("END")) {
            System.out.println(isPalindrome(row));
            row = scan.nextLine();
        }
    }

    private static boolean isPalindrome(String row) {
        boolean result = true;
        for (int i = 0; i < row.length() / 2; i++) {
            if (row.charAt(i) != row.charAt(row.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
