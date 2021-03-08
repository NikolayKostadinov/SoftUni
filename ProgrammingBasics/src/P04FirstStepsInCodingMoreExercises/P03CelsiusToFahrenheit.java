package P04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P03CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double celsiusDegrees = Double.parseDouble(scan.nextLine());
        double fahrenheitDegrees = celsiusDegrees * 1.8 + 32.0;

        System.out.printf("%.2f", fahrenheitDegrees);
    }
}
