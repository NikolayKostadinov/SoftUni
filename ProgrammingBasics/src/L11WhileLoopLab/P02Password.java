package L11WhileLoopLab;

import java.util.Scanner;

public class P02Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String password = scan.nextLine();
        String newPassword  =scan.nextLine();

        while (!password.equals(newPassword)){
            newPassword  =scan.nextLine();
        }

        System.out.printf("Welcome %s!", name);
    }
}
