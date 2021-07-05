package LME05ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!"Craft!".equals(command)){
            String[] tokens = command.split(" - ");
            String cmdName = tokens[0];
            String item = tokens[1];

            switch (cmdName){
                case "Collect":
                    if (!inventory.contains(item)) {
                        inventory.add(item);
                    }
                    break;
                case "Drop":
                    int index = inventory.indexOf(item);
                    if (index > -1){
                        inventory.remove(index);
                    }
                    break;
                case "Combine Items":
                    String[] items = item.split(":");
                    index = inventory.indexOf(items[0]);
                    if (index > -1){
                        inventory.add(index+1, items[1]);
                    }
                    break;
                case "Renew":{
                    index = inventory.indexOf(item);
                    if (index > -1){
                        inventory.add(inventory.get(index));
                        inventory.remove(index);
                    }
                    break;
                }
            }

            command = scan.nextLine();
        }

        System.out.println(inventory.toString().replaceAll("[\\[\\]]", ""));
    }
}
