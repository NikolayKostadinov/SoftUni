package LME06ProgrammingFundamentalsMidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> chest = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!"Yohoho!".equals(command)){
            String tokens[] = command.split("\\s");
            switch (tokens[0]){
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (!chest.contains(tokens[i])){
                            chest.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (0<=index && index < chest.size()){
                        chest.add(chest.get(index));
                        chest.remove(index);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    if (count > chest.size()) count = chest.size();
                    List<String> stolen = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        stolen.add(0, chest.get(chest.size()-1));
                        chest.remove(chest.size()-1);
                    }
                    System.out.println(stolen.toString().replaceAll("[\\[\\]]", ""));
                    break;
            }
            command = scan.nextLine();
        }

        if (chest.size() == 0){
            System.out.println("Failed treasure hunt.");
        } else {
            int sumLen = 0;
            for (String item : chest) {
                sumLen += item.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", sumLen/(double) chest.size());
        }
    }
}
