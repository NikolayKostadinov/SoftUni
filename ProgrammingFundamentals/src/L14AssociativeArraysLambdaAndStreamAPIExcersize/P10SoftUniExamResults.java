package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import java.util.*;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, Integer> submissionCount = new HashMap<>();
        Map<String, Integer> maxUserScore = new HashMap<>();

        while (!"exam finished".equals(command)) {
            String[] tokens = command.split("-");
            String userName = tokens[0];
            if (command.contains("banned")) {
                maxUserScore.remove(userName);
            } else {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                submissionCount.putIfAbsent(language, 0);
                submissionCount.put(language, submissionCount.get(language) + 1);
                maxUserScore.putIfAbsent(userName, 0);
                int currentUserScore = maxUserScore.get(userName);
                if (currentUserScore < points) {
                    maxUserScore.put(userName, points);
                }
            }

            command = scan.nextLine();
        }
        System.out.println("Results:");
        maxUserScore
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(student -> System.out.printf("%s | %d\n", student.getKey(), student.getValue()));

        System.out.println("Submissions:");
        submissionCount
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(language -> System.out.printf("%s - %d\n", language.getKey(), language.getValue()));
    }
}
