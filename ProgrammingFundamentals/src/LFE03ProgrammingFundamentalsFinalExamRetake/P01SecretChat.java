package LFE03ProgrammingFundamentalsFinalExamRetake;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();


        while (!"Reveal".equals(command)) {
            String[] tokens = command.split(":\\|:");
            boolean isOk = true;
            switch (tokens[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    input.insert(index, " ");
                    break;
                case "Reverse":
                    int indexOfToken = input.indexOf(tokens[1]);
                    if (indexOfToken > -1){
                        input.delete(indexOfToken, indexOfToken + tokens[1].length());
                        int lastIx = input.length();
                        tokens[1].chars().forEach(chr-> input.insert(lastIx,(char) chr));
                    }else{
                        System.out.println("error");
                        isOk = false;
                    }
                    break;
                case "ChangeAll":
                    replaceString(input, tokens[1], tokens[2]);
                    break;
            }
            if (isOk) System.out.println(input);
            command = scan.nextLine();
        }

        System.out.printf("You have a new text message: %s", input);
    }

    private static void replaceString(StringBuilder input, String oldString, String newString) {
        int indexOfOldString = input.indexOf(oldString);
        while (indexOfOldString > -1) {
            input.replace(indexOfOldString, indexOfOldString + oldString.length(), newString);
            indexOfOldString += newString.length();
            indexOfOldString = input.indexOf(oldString,indexOfOldString);
        }
    }
}
