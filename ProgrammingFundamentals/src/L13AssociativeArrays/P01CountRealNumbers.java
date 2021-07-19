package L13AssociativeArrays;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> input = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Double::parseDouble).collect(Collectors.toList());
        Map<Double, Integer> numbers = new TreeMap<>();
        for (Double number : input) {
            if (!numbers.containsKey(number)){
                numbers.put(number, 0);
            }
            numbers.put(number, numbers.get(number) + 1);
        }

        DecimalFormat df = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%s -> %d\n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
