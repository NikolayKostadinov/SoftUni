package L18RegularExpressionsExercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02Race {
    private static final String NAME_PATTERN = "[A-Z]|[a-z]";
    private static final String DISTANCE_PATTERN = "\\d";
    private static final String[] places = new String[]{"1st", "2nd", "3rd"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> contestants = new LinkedHashMap<>();
        Arrays.stream(scan.nextLine().split(", "))
                .forEach(name -> contestants.putIfAbsent(name, 0));

        String input = scan.nextLine();

        while (!"end of race".equals(input)) {
            String name = getNameFromString(input);
            int result = getDistanceFromString(input);
            if (contestants.containsKey(name)) {
                contestants.put(name, contestants.get(name) + result);
            }
            input = scan.nextLine();
        }

        AtomicInteger ix = new AtomicInteger(0);

        contestants
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(record -> {
                   System.out.printf("%s place: %s\n", places[ix.getAndIncrement()], record.getKey());
                });

    }

    private static int getDistanceFromString(String input) {
        Pattern pattern = Pattern.compile(DISTANCE_PATTERN);
        Matcher matcher = pattern.matcher(input);
        int distance = 0;
        while (matcher.find()){
            distance += Integer.parseInt(matcher.group());
        }

        return distance;
    }

    private static String getNameFromString(String input) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(input);
        StringBuilder name = new StringBuilder();
        while (matcher.find()){
            name.append(matcher.group());
        }
        return name.toString();
    }
}
