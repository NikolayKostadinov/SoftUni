package LFE05ProgrammingFundamentalsFinalExam;

import java.util.Locale;
import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder activationKey = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();

        while (!"Generate".equals(command)) {
            String[] tokens = command.split(">>>");
            switch (tokens[0]) {
                case "Contains":
                    if (activationKey.indexOf(tokens[1]) > -1) {
                        System.out.printf("%s contains %s\n", activationKey, tokens[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String charCase = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String substr = activationKey.substring(startIndex, endIndex);

                    if ("Upper".equals(charCase)) {
                        substr = substr.toUpperCase();
                    } else {
                        substr = substr.toLowerCase();
                    }

                    activationKey.replace(startIndex,endIndex,substr);
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    activationKey.delete(startIndex,endIndex);
                    System.out.println(activationKey);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.printf("Your activation key is: %s", activationKey);
    }
}
