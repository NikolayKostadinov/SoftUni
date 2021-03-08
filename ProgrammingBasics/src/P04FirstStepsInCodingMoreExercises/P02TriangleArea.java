package P04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P02TriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double triangle = a * h / 2.0;
        System.out.printf("%.2f", triangle);
    }
}
