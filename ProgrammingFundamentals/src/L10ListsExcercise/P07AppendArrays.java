package L10ListsExcercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrays = scan.nextLine().split("\\|");
        List<Integer> result = new ArrayList<>();
        for (int i = arrays.length - 1; i >= 0 ; i--) {
            if (!arrays[i].trim().equals("")){
            result.addAll(Arrays.stream(arrays[i].trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
