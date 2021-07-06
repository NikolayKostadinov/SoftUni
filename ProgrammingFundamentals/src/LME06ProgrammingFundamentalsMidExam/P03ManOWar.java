package LME06ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.Scanner;

public class P03ManOWar {
    public static int[] pirateShipSections;
    public static int[] warShipSections;
    public static int maximumHealthCapacity;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        pirateShipSections = Arrays.stream(scan.nextLine().split(">"))
                .mapToInt(Integer::parseInt).toArray();
        warShipSections = Arrays.stream(scan.nextLine().split(">"))
                .mapToInt(Integer::parseInt).toArray();

        maximumHealthCapacity = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();

        while (!"Retire".equals(command)) {
            String[] tokens = command.split("\\s");
            switch (tokens[0]) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    if (!fire(index, damage)) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    damage = Integer.parseInt(tokens[3]);
                    if (!defend(startIndex, endIndex, damage)) {
                        System.out.println("You lost! The pirate ship has sunken.");
                        return;
                    }
                    break;
                case "Repair":
                     index = Integer.parseInt(tokens[1]);
                     int health = Integer.parseInt(tokens[2]);
                     repair(index, health);
                    break;
                case "Status":
                    status();
                    break;
            }
            command = scan.nextLine();
        }

        System.out.printf("Pirate ship status: %d\n", Arrays.stream(pirateShipSections).sum());
        System.out.printf("Warship status: %d", Arrays.stream(warShipSections).sum());
    }

    private static void status() {
        double percentage = maximumHealthCapacity * 0.2;
        int count = 0;
        for (int pirateShipSection : pirateShipSections) {
            if (pirateShipSection < percentage){
                count++;
            }
        }

        System.out.printf("%d sections need repair.\n", count);
    }

    private static void repair(int index, int health) {
        if (0 <= index && index < pirateShipSections.length) {
            pirateShipSections[index] += health;
            if (pirateShipSections[index] > maximumHealthCapacity) pirateShipSections[index] = maximumHealthCapacity;
        }
    }

    private static boolean fire(int index, int damage) {
        if (0 <= index && index < warShipSections.length) {
            warShipSections[index] -= damage;
            if (warShipSections[index] <= 0) return false;
        }
        return true;
    }

    private static boolean defend(int startIndex, int endIndex, int damage) {
        if (0 <= startIndex
                && startIndex <= endIndex
                && endIndex < pirateShipSections.length) {
            for (int i = startIndex; i <= endIndex; i++) {
                pirateShipSections[i] -= damage;
                if (pirateShipSections[i] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
