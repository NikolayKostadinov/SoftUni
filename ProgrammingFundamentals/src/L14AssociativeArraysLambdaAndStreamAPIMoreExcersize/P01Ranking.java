package L14AssociativeArraysLambdaAndStreamAPIMoreExcersize;

import java.util.*;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, String> contests = new HashMap<>();

        while (!"end of contests".equals(command)) {
            String[] tokens = command.split(":");
            if (tokens.length == 2) {
                contests.putIfAbsent(tokens[0], tokens[1]);
            }
            command = scan.nextLine();
        }

        Map<String, Map<String, Integer>> usersContests = new TreeMap<>();
        command = scan.nextLine();
        while (!"end of submissions".equals(command)) {
            String[] tokens = command.split("=>");

            if (tokensAreValid(tokens)
                    && isPasswordCorrect(tokens[0], tokens[1], contests)) {

                String contest = tokens[0];
                String userName = tokens[2];
                int points = Integer.parseInt(tokens[3]);

                usersContests.putIfAbsent(userName, new LinkedHashMap<>());
                Map<String, Integer> usersPoints = usersContests.get(userName);
                usersPoints.putIfAbsent(contest, 0);

                int currentPoints = usersPoints.get(contest);

                if (points > currentPoints) {
                    usersPoints.put(contest, points);
                }
            }
            command = scan.nextLine();
        }

        var maxUser =
                usersContests
                .entrySet()
                .stream()
                .map(x-> {
                    int sum = x.getValue()
                            .entrySet()
                            .stream()
                            .mapToInt(e->e.getValue()).sum();
                    return new AbstractMap.SimpleEntry<String, Integer>(x.getKey(), sum);
                })
                .max((o1, o2) -> o1.getValue() - o2.getValue()).get();
        System.out.printf("Best candidate is %s with total %d points.\n", maxUser.getKey(), maxUser.getValue());

        System.out.println("Ranking: ");
        usersContests
                .entrySet()
                .stream()
                .forEach(user -> {
                    System.out.println(user.getKey());
                    Map<String, Integer> results = user.getValue();
                    results
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(contest -> System.out.printf("#  %s -> %d\n", contest.getKey(), contest.getValue()));
                });
    }

    private static boolean isPasswordCorrect(String contest, String password, Map<String, String> contests) {
        return contests.containsKey(contest) && contests.get(contest).equals(password);
    }

    private static boolean tokensAreValid(String[] tokens) {
        int token3 = Integer.parseInt(tokens[3]);
        return !(tokens.length < 4 || tokens[0].contains(":") || tokens[0].contains("=") || tokens[0].contains(">")
                || tokens[1].contains(":") || tokens[1].contains("=") || tokens[1].contains(">")
                || tokens[2].contains(":") || tokens[2].contains("=") || tokens[2].contains(">")
                || token3 < 0 || token3 > 10000);
    }
}
