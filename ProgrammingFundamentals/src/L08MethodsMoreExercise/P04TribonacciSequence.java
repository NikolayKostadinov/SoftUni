package L08MethodsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> tribonacci = new ArrayList<>();
        tribonacci.add(1);
        tribonacci.add(1);
        tribonacci.add(2);

        int num = Integer.parseInt(scan.nextLine());
        for (int i = 3; i < num; i++) {
            int nextNum = tribonacci.get(i-3)+tribonacci.get(i-2)+tribonacci.get(i-1);
            tribonacci.add(nextNum);
        }
        tribonacci = tribonacci.subList(0,num);
        System.out.println(tribonacci.toString().replaceAll("[\\[\\],]",""));
    }
}
