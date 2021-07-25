package L14AssociativeArraysLambdaAndStreamAPIMoreExcersize;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        while (!"no more time".contains(command)) {
            String[] tokens = command.split(" -> ");
            String userName = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            contests.putIfAbsent(contest, new LinkedHashMap<>());
            Map<String, Integer> users = contests.get(contest);
            users.putIfAbsent(userName, 0);
            if (users.get(userName) < points) {
                users.put(userName, points);
            }
            command = scan.nextLine();
        }

        Map<String, Integer> userScore = new LinkedHashMap<>();

        contests
                .entrySet()
                .stream()
                .forEach(e -> {
                    Map<String, Integer> participants = e.getValue();
                    System.out.printf("%s: %d participants\n", e.getKey(), participants.entrySet().stream().count());
                    AtomicInteger position = new AtomicInteger(1);
                    participants
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                                    .thenComparing(Map.Entry.comparingByKey()))
                            .forEach(part -> {
                                String user = part.getKey();
                                int points = part.getValue();
                                System.out.printf("%d. %s <::> %d\n", position.getAndIncrement(), user, points);
                                userScore.putIfAbsent(user, 0);
                                userScore.put(user, userScore.get(user) + points);
                            });
                });

        AtomicInteger position = new AtomicInteger(1);
        System.out.println("Individual standings:");
        userScore
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(usr -> System.out.printf("%d. %s -> %d\n",
                        position.getAndIncrement(), usr.getKey(), usr.getValue()));
    }
}
