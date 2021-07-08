package L10ListsMoreExcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split("\\s");
        List<String> text = Arrays.stream(scan.nextLine().split("")).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            int position = Arrays.stream(numbers[i].split("")).mapToInt(Integer::parseInt).sum();
            if (position > text.size()-1) position -= text.size();
            sb.append(text.get(position));
            text.remove(position);
        }

        System.out.println(sb);
    }
}
