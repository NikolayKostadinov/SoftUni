package P04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P01TrapezoidArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double b1 = Double.parseDouble(scan.nextLine());
        double b2 = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double trapezoidArea = (b1 + b2) * h / 2.0;
        System.out.printf("%.2f", trapezoidArea);
    }
}
