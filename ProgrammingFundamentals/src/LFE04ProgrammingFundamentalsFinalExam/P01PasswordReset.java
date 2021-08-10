package LFE04ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();

        while (!"Done".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "TakeOdd":
                    int length = password.length();
                    for (int i = 1; i < length; i += 2) {
                        password.append(password.charAt(i));
                    }
                    password.delete(0, length);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    length = Integer.parseInt(tokens[2]);
                    password.delete(index, index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (password.indexOf(substring) > -1) {
                        password = new StringBuilder(
                                password.toString().replaceAll(substring, substitute));
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            command = scan.nextLine();
        }

        System.out.printf("Your password is: %s", password);
    }
}
