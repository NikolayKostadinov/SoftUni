package L08MethodsExercise;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        int result = substract(add(a, b), c);
        System.out.println(result);
    }

    private static int substract(int a, int b) {
        return a - b;
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
