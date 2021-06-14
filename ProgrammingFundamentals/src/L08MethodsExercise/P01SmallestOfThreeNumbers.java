package L08MethodsExercise;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        System.out.println(getSmallest(a, b, c));
    }

    private static int getSmallest(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
