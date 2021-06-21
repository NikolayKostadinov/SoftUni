package L10ListsExcercise;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> distances = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Double sum = 0.0;
        while (distances.size() > 0) {
            int index = Integer.parseInt(scan.nextLine());
            int element = normalizeIndex(distances, index);
            sum += element;
            for (int i = 0; i < distances.size(); i++) {
                if (distances.get(i) <= element) {
                    distances.set(i, distances.get(i) + element);
                } else {
                    distances.set(i, distances.get(i) - element);
                }
            }
        }

        System.out.println(new DecimalFormat("0.#").format(sum));
    }

    private static int normalizeIndex(List<Integer> distances, int index) {
        if (index < 0){
            int result = distances.get(0);
            distances.remove(0);
            distances.add(0, distances.get(distances.size()-1));
            return result;
        }else if (index > distances.size() - 1) {
            int result = distances.get(distances.size()-1);
            distances.remove(distances.size()-1);
            distances.add(distances.get(0));
            return result;
        }

        int result = distances.get(index);
        distances.remove(index);
        return result;
    }
}
