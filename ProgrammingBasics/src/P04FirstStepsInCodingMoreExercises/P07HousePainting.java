package P04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P07HousePainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double wallArea = (2.0 * x * x) + (2.0 * x * y) - (1.2 * 2.0) - (1.5 * 1.5) * 2.0;
        double roofArea = (h*x) + (x * y) * 2.0;

        System.out.printf("%.2f%n%.2f", wallArea / 3.4, roofArea / 4.3);
    }
}
