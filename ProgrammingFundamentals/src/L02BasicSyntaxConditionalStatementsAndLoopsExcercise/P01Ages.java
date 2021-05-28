package L02BasicSyntaxConditionalStatementsAndLoopsExcercise;

import java.util.Scanner;

public class P01Ages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = Integer.parseInt(scan.nextLine());

        String result = "";
        if (0 <= age && age <= 2) {
            result = "baby";
        } else if (3 <= age && age <= 13) {
            result = "child";
        } else if (14 <= age && age <= 19) {
            result = "teenager";
        } else if (20 <= age && age <= 65) {
            result = "adult";
        } else if (age >= 66) {
            result = "elder";
        }

        System.out.println(result);
    }
}
