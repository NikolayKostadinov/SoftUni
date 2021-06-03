package L02BasicSyntaxConditionalStatementsAndLoopsExcercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        String passWord = "";

        for (int i = userName.length() - 1; i >= 0; i--) {
            passWord += userName.charAt(i);
        }

        int count = 1;
        while (!passWord.equals(scan.nextLine()) && count < 4) {
            System.out.println("Incorrect password. Try again.");
            count++;
        }

        if (count == 4) {
            System.out.printf("User %s blocked!", userName);
        } else {
            System.out.printf("User %s logged in.", userName);
        }
    }
}
