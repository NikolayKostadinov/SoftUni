package L10ForLoopExercise;

import java.util.Scanner;

public class P03OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double minEvenElement = Double.MAX_VALUE;
        double maxEvenElement = -Double.MAX_VALUE;
        double sumEven = 0;
        int countEven = 0;
        double minOddElement = Double.MAX_VALUE;
        double maxOddElement = -Double.MAX_VALUE;
        double sumOdd = 0;
        int countOdd = 0;

        double num = 0;
        for (int i = 1; i <= n; i++) {
            num = Double.parseDouble(scan.nextLine());
            if (i % 2 == 0) {
                sumEven += num;
                countEven++;
                if (minEvenElement > num) minEvenElement = num;
                if (maxEvenElement < num) maxEvenElement = num;
            } else {
                sumOdd += num;
                countOdd++;
                if (minOddElement > num) minOddElement = num;
                if (maxOddElement < num) maxOddElement = num;
            }
        }

        System.out.printf("OddSum=%.2f,\n", sumOdd);
        if (countOdd > 0)
            System.out.printf("OddMin=%.2f,\nOddMax=%.2f,\n", minOddElement, maxOddElement);
        else
            System.out.printf("OddMin=No,\nOddMax=No,\n");
        System.out.printf("EvenSum=%.2f,\n", sumEven);
        if (countEven > 0)
            System.out.printf("EvenMin=%.2f,\nEvenMax=%.2f\n", minEvenElement, maxEvenElement);
        else
            System.out.printf("EvenMin=No,\nEvenMax=No\n");
    }
}
