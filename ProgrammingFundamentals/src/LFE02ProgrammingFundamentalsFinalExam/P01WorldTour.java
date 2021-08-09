package LFE02ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!"Travel".equals(command)) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add Stop":
                    addStop(input, Integer.parseInt(tokens[1]), tokens[2]);
                    System.out.println(input);
                    break;
                case "Remove Stop":
                    removeStop(input, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    System.out.println(input);
                    break;
                case "Switch":
                    replaceString(input, tokens[1], tokens[2]);
                    System.out.println(input);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", input);
    }

    private static void replaceString(StringBuilder input, String oldString, String newString) {
        int indexOfOldString = input.indexOf(oldString);
        while (indexOfOldString > -1) {
            input.replace(indexOfOldString, indexOfOldString + oldString.length(), newString);
            indexOfOldString += newString.length();
            indexOfOldString = input.indexOf(oldString,indexOfOldString);
        }
    }

    private static void removeStop(StringBuilder input, int startIndex, int endIndex) {
        if (0 <= startIndex && startIndex < input.length()
                && 0 <= endIndex && endIndex < input.length()
                && startIndex <= endIndex) {
            input.delete(startIndex, endIndex + 1);
        }
    }

    private static void addStop(StringBuilder input, int index, String stop) {
        if (0 <= index && index < input.length()) {
            input.insert(index, stop);
        }
    }
}
