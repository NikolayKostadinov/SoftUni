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
                String[] tokens = command.split(" \\| ");
                String forceUser = tokens[1];
                String forceSite = tokens[0];

                if (sites
                        .entrySet()
                        .stream()
                        .allMatch(x -> !x.getValue().contains(forceUser))) {
                    sites.putIfAbsent(forceSite, new ArrayList<>());
                    List<String> users = sites.get(forceSite);
                    users.add(forceUser);
                }
            } else if (command.contains(" -> ")) {
                String[] tokens = command.split(" -> ");
                String forceUser = tokens[0];
                String forceSite = tokens[1];
                sites.putIfAbsent(forceSite, new ArrayList<>());
                sites
                        .entrySet()
                        .stream()
                        .forEach(x -> x.getValue().remove(forceUser));
                sites.get(forceSite).add(forceUser);
                System.out.printf("%s joins the %s side!\n", forceUser, forceSite);
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
                            .forEach(u -> System.out.printf("! %s\n", u));
                });
    }
}
