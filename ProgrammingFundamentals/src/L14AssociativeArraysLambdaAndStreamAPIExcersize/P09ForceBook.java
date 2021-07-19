package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import javax.lang.model.element.NestingKind;
import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, List<String>> sites = new HashMap<>();

        while (!"Lumpawaroo".equals(command)) {

            if (command.contains(" | ")) {
                String[] tokens = command.split(" | ");
                sites.putIfAbsent(tokens[0], new ArrayList<>());
                List<String> users = sites.get(tokens[0]);
                if (!users.contains(tokens[1])) {
                    users.add(tokens[0]);
                }
            } else if (command.contains(" -> ")) {
                String[] tokens = command.split(" -> ");
                sites.putIfAbsent(tokens[1], new ArrayList<>());
                sites
                        .entrySet()
                        .stream()
                        .forEach(x -> x.getValue().remove(tokens[0]));
                sites.get(tokens[1]).add(tokens[0]);
                System.out.printf("%s joins the %s side!\n", tokens[0], tokens[1]);
            }

            command = scan.nextLine();
        }

        sites
                .entrySet()
                .stream()
                .filter(x -> x.getValue().size() > 0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue((c1, c2) -> c2.size() - c1.size())
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry ->
                {
                    List<String> users = entry.getValue();
                    System.out.printf("Side: %s, Members: %d\n", entry.getKey(), users.size());
                    users
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(u -> System.out.printf("!%s\n", u));
                });
    }
}
