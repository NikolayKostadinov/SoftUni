package FinalExam;

import java.util.*;

public class P03Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> guests = new TreeMap<>();

        int unlikedMealsCount = 0;

        String command = scan.nextLine();

        while (!"Stop".equals(command)) {
            String[] tokens = command.split("-");
            String guest = tokens[1];
            String meal = tokens[2];
            switch (tokens[0]) {
                case "Like":
                    guests.putIfAbsent(guest, new ArrayList<>());
                    if (!guests.get(guest).contains(meal)) {
                        guests.get(guest).add(meal);
                    }
                    break;
                case "Unlike":
                    if (guests.containsKey(guest)) {
                        if (guests.get(guest).contains(meal)) {
                            guests.get(guest).remove(meal);
                            unlikedMealsCount++;
                            System.out.printf("%s doesn't like the %s.\n",guest, meal);
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.\n", guest, meal);
                        }
                    } else {
                        System.out.printf("%s is not at the party.\n", guest);
                    }
                    break;
            }
            command = scan.nextLine();
        }

        guests
                .entrySet()
                .stream()
                .sorted((g1, g2) -> g2.getValue().size() - g1.getValue().size())
                .forEach(g-> System.out.printf("%s: %s\n", g.getKey(), String.join(", ", g.getValue())));
        System.out.printf("Unliked meals: %d\n", unlikedMealsCount);
    }
}
