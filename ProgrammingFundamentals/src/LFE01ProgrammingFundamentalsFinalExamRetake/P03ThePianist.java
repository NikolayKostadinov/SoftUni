package LFE01ProgrammingFundamentalsFinalExamRetake;

import java.util.*;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, String>> pieces = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\|");
            pieces.putIfAbsent(tokens[0], new TreeMap<>());
            pieces.get(tokens[0]).putIfAbsent(tokens[1], tokens[2]);
        }

        String command = scan.nextLine();

        while (!"Stop".equals(command)) {
            String[] tokens = command.split("\\|");
            switch (tokens[0]) {
                case "Add":
                    if (pieces.containsKey(tokens[1])) {
                        System.out.printf("%s is already in the collection!\n", tokens[1]);
                    } else {
                        pieces.put(tokens[1], new TreeMap<>());
                        Map<String, String> composer = pieces.get(tokens[1]);
                        composer.putIfAbsent(tokens[2], tokens[3]);
                        System.out.printf("%s by %s in %s added to the collection!\n", tokens[1], tokens[2], tokens[3]);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(tokens[1])) {
                        pieces.remove(tokens[1]);
                        System.out.printf("Successfully removed %s!\n", tokens[1]);

                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", tokens[1]);
                    }
                    break;
                case "ChangeKey":
                    if (pieces.containsKey(tokens[1])){
                        Map.Entry<String, String> composer = pieces.get(tokens[1]).entrySet().stream().findFirst().orElse(null);
                        pieces.get(tokens[1]).put(composer.getKey(), tokens[2]);
                        System.out.printf("Changed the key of %s to %s!\n", tokens[1], tokens[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", tokens[1]);
                    }
                    break;
            }
            command = scan.nextLine();
        }

        pieces
                .entrySet()
                .stream()
                .forEach(p->
                    p.getValue()
                            .entrySet()
                            .stream()
                            .forEach(c-> System.out.printf("%s -> Composer: %s, Key: %s\n",p.getKey(),c.getKey(),c.getValue())));
    }
}
