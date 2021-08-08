package LFE01ProgrammingFundamentalsFinalExamRetake;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();

        while (!"Decode".equals(command)) {
            String[] tokens = command.split("\\|");
            switch (tokens[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    if (numberOfLetters > input.length()){
                        numberOfLetters = input.length();
                    }
                    input.append(input.substring(0, numberOfLetters));
                    input.delete(0, numberOfLetters);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    input.insert(index, tokens[2]);
                    break;
                case "ChangeAll":
                    replaceAll(input, tokens[1], tokens[2]);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.printf("The decrypted message is: %s", input);
    }

    public static void replaceAll(StringBuilder builder, String substring, String replacement) {
        int index = builder.indexOf(substring);
        while (index != -1) {
            builder.replace(index, index + substring.length(), replacement);
            index += replacement.length(); // Move to the end of the replacement
            index = builder.indexOf(substring, index);
        }
    }
}
