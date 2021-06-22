package L10ListsExcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!"end".equals(command)){
            String[] tokens = command.split(" ");

            switch (tokens[0]){
                case "Delete":
                    list.removeAll(Arrays.asList(Integer.parseInt(tokens[1])));
                    break;
                case "Insert":
                    list.add(Integer.parseInt(tokens[2]),Integer.parseInt(tokens[1]));
                    break;
            }

            command = scan.nextLine();
        }

        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
