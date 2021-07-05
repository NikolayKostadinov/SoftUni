package LME03ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    private static List<Integer> targets;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        targets = Arrays.stream(scan.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scan.nextLine();

        while (!"End".equals(command)){
            String[] tokens = command.split("\\s");
            int index = Integer.parseInt(tokens[1]);
            int value = Integer.parseInt(tokens[2]);
            switch (tokens[0]){
                case "Shoot":
                    shootTarget(index, value);
                    break;
                case "Add":
                    addTarget(index, value);
                    break;
                case "Strike":
                    strikeTargets(index, value);
                    break;
            }

            command = scan.nextLine();
        }
        System.out.println(targets.toString().replaceAll("[\\[\\]\\s]", "").replaceAll(",","|"));
    }

    private static void strikeTargets(int index, int value) {
        int startIndex = index - value;
        int endIndex = index + value;
        if (0 <= startIndex && endIndex < targets.size()){
            for (int i = endIndex; i >= startIndex; i--) {
                targets.remove(i);
            }
        } else {
            System.out.println("Strike missed!");
        }
    }

    private static void addTarget(int index, int value) {
        if (0 <= index && index < targets.size()){
            targets.add(index, value);
        }else{
            System.out.println("Invalid placement!");
        }
    }

    private static void shootTarget(int index, int value) {
        if (0 <= index && index < targets.size()){
            int newValue = targets.get(index) - value;
            if (newValue > 0){
                targets.set(index, newValue);
            }else{
                targets.remove(index);
            }
        }
    }

}
