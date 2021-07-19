package L13AssociativeArrays;

import java.util.*;
import java.util.stream.Collectors;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split("\\s")).collect(Collectors.toList());
        Map<String, Integer> words = new LinkedHashMap<>();

        input.forEach(x -> {
            String xl = x.toLowerCase(Locale.ROOT);
            words.putIfAbsent(xl, 0);
            words.put(xl, words.get(xl) + 1);
        });

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() % 2 != 0) result.add(entry.getKey());
        }

        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }
}
