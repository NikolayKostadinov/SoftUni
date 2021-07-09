package L10ListsMoreExcercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> initialDrumsQuality = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumsQuality = new ArrayList<>();
        drumsQuality.addAll(initialDrumsQuality);

        String command = scan.nextLine();

        while (!"Hit it again, Gabsy!".equals(command)) {
            int hitPower = Integer.parseInt(command);
            for (int i = 0; i < drumsQuality.size(); i++) {
                drumsQuality.set(i, drumsQuality.get(i) - hitPower);
                if (drumsQuality.get(i) <= 0) {
                    double difference = savings - (initialDrumsQuality.get(i) * 3);
                    if (difference >= 0) {
                        drumsQuality.set(i, initialDrumsQuality.get(i));
                        savings = difference;
                    } else {
                        drumsQuality.remove(i);
                        initialDrumsQuality.remove(i);
                        i--;
                    }
                }
            }
            command = scan.nextLine();
        }

        System.out.println(drumsQuality.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
