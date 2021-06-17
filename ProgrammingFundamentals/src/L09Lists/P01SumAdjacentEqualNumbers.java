package L09Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> input = Arrays.stream(scan.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> result = sumAdjacentEqualNumbers(input);

        StringBuilder sb = new StringBuilder();
        for (double num : result) {
            sb.append(new DecimalFormat("0.#").format(num));
            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static List<Double> sumAdjacentEqualNumbers(List<Double> input) {
        int adjacentEqualCounter;
        List<Double> result = new ArrayList<>();

            adjacentEqualCounter = 0;
            for (int i = 0; i < input.size() - 1; i++) {
                if (input.get(i).equals(input.get(i+1))){
                    input.set(i, (input.get(i)+input.get(i+1)));
                    input.remove(i+1);
                    i=-1;
                }
            }

        return input;
    }
}
