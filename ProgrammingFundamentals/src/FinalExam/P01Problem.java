package FinalExam;

import java.util.Scanner;

public class P01Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Translate":
                    String character = tokens[1];
                    String replacement = tokens[2];
                    replaceAll(input, character, replacement);
                    System.out.println(input);
                    break;
                case "Includes":
                    System.out.println((input.indexOf(tokens[1]) > -1) ? "True" : "False");
                    break;
                case "Start":
                    System.out.println((input.indexOf(tokens[1]) == 0) ? "True" : "False");
                    break;
                case "Lowercase":
                    input = new StringBuilder(input.toString().toLowerCase());
                    System.out.println(input);
                    break;
                case "FindIndex":
                    System.out.println(input.lastIndexOf(tokens[1]));
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    input = input.delete(startIndex, startIndex + count);
                    System.out.println(input);
                    break;
            }
            command = scan.nextLine();
        }
    }

    public static void replaceAll(StringBuilder builder, String substring, String replacement) {
        int index = builder.indexOf(substring);
        while (index != -1) {
            builder.replace(index, index + substring.length(), replacement);
            index += replacement.length();
            index = builder.indexOf(substring, index);
        }
    }
}
