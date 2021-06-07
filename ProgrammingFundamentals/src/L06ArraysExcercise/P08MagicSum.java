package L06ArraysExcercise;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int number = Integer.parseInt(scan.nextLine());
        String pairs = "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == number){
//                    String pair = String.format("%d %d", numbers[i], numbers[j]);
//                    if (!pairs.contains(pair)){
//                        pairs+=String.format("%s\n", pair);
//                    }

                    System.out.printf("%d %d\n", numbers[i], numbers[j]);
                }
            }
        }

        System.out.println(pairs);
    }
}
