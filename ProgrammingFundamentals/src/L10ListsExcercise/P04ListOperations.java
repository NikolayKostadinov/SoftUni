package L10ListsExcercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!"End".equals(command)){
            String[] tokens = command.split(" ");
            switch (tokens[0]){
                case "Add":
                    list.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    int number = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    if(checkIndex(list, index)){
                        list.add(index, number);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if(checkIndex(list, index)){
                        list.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(tokens[2]);
                    switch (tokens[1]){
                        case "left":
                            for (int i = 0; i < count; i++) {
                                int buff = list.get(0);
                                list.remove(0);
                                list.add(buff);
                            }
                            break;
                        case "right":
                            for (int i = 0; i < count; i++) {
                                int buff = list.get(list.size() - 1);
                                list.remove(list.size() - 1);
                                list.add(0, buff);
                            }
                            break;
                    }
                    break;
            }

            command = scan.nextLine();
        }

        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }

    private static boolean checkIndex(List<Integer> list, int index) {
        return 0 <= index && index < list.size();
    }
}
