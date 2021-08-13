package L18RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> attacked = new TreeMap<>();
        Map<String, Integer> destroyed = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            String encrypted = scan.nextLine();
            String message = decrypt(encrypted);
            Pattern pattern = Pattern.compile("@([^@\\-!:>])*?(?<palnet>[A-Za-z]+)([^@\\-!:>])*?:([^@\\-!:>])*?(\\d+)([^@\\-!:>])*?!([^@\\-!:>])*?(?<thread>A|D)([^@\\-!:>])*?!([^@\\-!:>])*?->([^@\\-!:>])*?\\d+");
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()){
                if (matcher.group("thread").equals("A")){
                    attacked.putIfAbsent(matcher.group("palnet"), 0);
                } else {
                    destroyed.putIfAbsent(matcher.group("palnet"), 0);
                }
            }
        }

        System.out.printf("Attacked planets: %d\n", attacked.entrySet().size());
        attacked
                .entrySet()
                .stream()
                .forEach(entr-> System.out.printf("-> %s\n", entr.getKey()));
        System.out.printf("Destroyed planets: %d\n", destroyed.entrySet().size());
        destroyed
                .entrySet()
                .stream()
                .forEach(entr-> System.out.printf("-> %s\n", entr.getKey()));
    }

    private static String decrypt(String encrypted) {
        String ptrn = "[start]|[START]";
        Pattern pattern = Pattern.compile("[start]|[START]");
        Matcher matcher = pattern.matcher(encrypted);

        int key = 0;
        while (matcher.find()){
            key++;
        }
        StringBuilder sb = new StringBuilder(encrypted.length());

        for (char chr : encrypted.toCharArray()) {
            sb.append((char)(chr - key));
        }

        return sb.toString();
    }
}
