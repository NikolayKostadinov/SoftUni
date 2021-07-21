package L14AssociativeArraysLambdaAndStreamAPIMoreExcersize;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class P03MOBA_Challenger {
    public static Map<String, Map<String, Integer>> players = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        while (!"Season end".equals(command)) {
            if (command.contains(" -> ")) {
                processPlayer(command);
            } else if (command.contains(" vs ")) {
                makeDuel(command);
            }
            command = scan.nextLine();
        }

        players
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int total1 = p1.getValue().entrySet().stream().mapToInt(p -> p.getValue().intValue()).sum();
                    int total2 = p2.getValue().entrySet().stream().mapToInt(p -> p.getValue().intValue()).sum();
                    int result = total2 - total1;
                    if (result == 0) {
                        p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                })
                .forEach(player -> {
                    Map<String, Integer> skills = player.getValue();
                    System.out.printf("%s: %d skill\n", player.getKey(), skills.entrySet().stream().mapToInt(p -> p.getValue().intValue()).sum());

                    skills.entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                                    .thenComparing(Map.Entry.comparingByKey()))
                            .forEach(skill -> System.out.printf("- %s <::> %d\n",
                                    skill.getKey(), skill.getValue()));
                });
    }

    private static void makeDuel(String command) {
        String[] tokens = command.split(" vs ");
        if (players.containsKey(tokens[0])
                && players.containsKey(tokens[1])) {
            Map<String, Integer> player1 = players.get(tokens[0]);
            Map<String, Integer> player2 = players.get(tokens[1]);

            player1
                    .entrySet()
                    .stream()
                    .forEach(p -> {
                        if (player2.containsKey(p.getKey())) {
                            int player1Total = player1.entrySet().stream().mapToInt(Map.Entry::getValue).sum();
                            int player2Total = player2.entrySet().stream().mapToInt(Map.Entry::getValue).sum();

                            if (player1Total > player2Total){
                                players.remove(tokens[1]);
                            } else if (player1Total < player2Total) {
                                players.remove(tokens[0]);
                            }
                            return;
                        }
                    });
        }
    }

    private static void processPlayer(String command) {
        String[] tokens = command.split(" -> ");
        String player = tokens[0];
        String skill = tokens[1];
        int value = Integer.parseInt(tokens[2]);

        players.putIfAbsent(tokens[0], new HashMap<>());

        Map<String, Integer> positions = players.get(tokens[0]);
        positions.putIfAbsent(skill, 0);

        if (positions.get(skill) < value) {
            positions.put(skill, value);
        }
    }
}
