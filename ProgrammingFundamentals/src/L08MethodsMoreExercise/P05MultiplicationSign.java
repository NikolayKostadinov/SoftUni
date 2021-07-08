package L08MethodsMoreExercise;

import java.util.Scanner;

public class P05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(scan.nextLine());
        arr[1] = Integer.parseInt(scan.nextLine());
        arr[2] = Integer.parseInt(scan.nextLine());

        int countMinus = 0;
        boolean hasZero = false;
        for (int number : arr) {
            if (number < 0) countMinus++;
            if (number == 0) {
                System.out.println("zero");
                return;
            }

        }

        if (countMinus % 2 == 0){
            System.out.println("positive");
        }else{
            System.out.println("negative");
        }
    }
}
