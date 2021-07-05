package LME02ProgrammingFundamentalsMidExam;

import java.util.*;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine()
                .split("\\s")).mapToInt(Integer::parseInt).toArray();
        List<Integer> result = new ArrayList<>();
        double average  = Arrays.stream(arr).sum() / (double) Arrays.stream(arr).count();

        for (int number : arr) {
            if (number > average){
                result.add(number);
            }
        }

        result.sort(Comparator.reverseOrder());

        int resultLen = (result.size() < 5) ? result.size() : 5;
        if (resultLen > 0){
        for (int i = 0; i < resultLen; i++) {
            System.out.printf("%d ", result.get(i));
        }} else {
            System.out.println("No");
        }
    }

}
