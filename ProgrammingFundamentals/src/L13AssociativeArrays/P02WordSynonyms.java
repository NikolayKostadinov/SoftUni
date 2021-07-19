package L13AssociativeArrays;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        Map<String, List<String>> dictionary = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();

            if (!dictionary.containsKey(word)){
                dictionary.put(word, new ArrayList<>());
            }
            dictionary.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue().toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
