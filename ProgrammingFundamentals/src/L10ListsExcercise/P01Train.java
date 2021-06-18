package L10ListsExcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();

        while (!"end".equals(command)){
            String[] tokens = command.split(" ");
            if ("Add".equals(tokens[0])){
                wagons.add(Integer.parseInt(tokens[1]));
            }else{
                addPassengers(wagons, Integer.parseInt(tokens[0]), maxCapacity);
            }

            command = scan.nextLine();
        }

        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
    private static void addPassengers(List<Integer> wagons, int addedPassengers, int maxCapacity) {
        for (int i = 0; i < wagons.size(); i++) {
            int passengers = wagons.get(i);
            int sumPassengers = passengers + addedPassengers;
            if (sumPassengers <= maxCapacity){
                wagons.set(i,sumPassengers);
                break;
            }
        }
    }
}
