package LME04ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.next().split("!")).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!"Go Shopping!".equals(command)) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "Urgent":
                    if (!list.contains(tokens[1]))
                        list.add(0, tokens[1]);
                    break;
                case "Unnecessary":
                    int index = list.indexOf(tokens[1]);
                    if (index > -1) list.remove(index);
                    break;
                case "Correct":
                    index = list.indexOf(tokens[1]);
                    if (index > -1) list.set(index, tokens[2]);
                    break;
                case "Rearrange":
                    index = list.indexOf(tokens[1]);
                    if (index > -1) {
                        list.remove(index);
                        list.add(tokens[1]);
                    }
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
    }
}
