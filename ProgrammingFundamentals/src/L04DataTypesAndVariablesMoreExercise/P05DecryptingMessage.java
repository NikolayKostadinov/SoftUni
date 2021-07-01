package L04DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        StringBuilder message = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            char character = scan.nextLine().charAt(0);
            message.append((char)(character + key));
        }

        System.out.println(message);
    }
}
