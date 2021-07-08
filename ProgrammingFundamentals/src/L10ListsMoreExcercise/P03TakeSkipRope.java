package L10ListsMoreExcercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> nonNumber = Arrays.stream(scan.nextLine().split("")).collect(Collectors.toList());
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = nonNumber.size() - 1; i >= 0; i--) {
            String currentChar = nonNumber.get(i);
            if (Character.isDigit(currentChar.charAt(0))) {
                takeList.add(0, Integer.parseInt(currentChar));
                nonNumber.remove(i);
            }
        }

        for (int i = takeList.size() - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                skipList.add(0, takeList.get(i));
                takeList.remove(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int skip = 0;
        for (int i = 0; i < takeList.size(); i++) {
            for (int j = 0; j < takeList.get(i); j++) {
                if (j+skip < nonNumber.size())
                sb.append(nonNumber.get(j + skip));
            }
            skip += takeList.get(i) + skipList.get(i);
        }

        System.out.println(sb);
    }
}
