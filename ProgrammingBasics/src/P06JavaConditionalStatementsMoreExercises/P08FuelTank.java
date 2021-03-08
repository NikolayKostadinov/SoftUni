package P06JavaConditionalStatementsMoreExercises;

import java.util.Locale;
import java.util.Scanner;

public class P08FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine().toLowerCase(Locale.ROOT);
        double fuelLeft = Double.parseDouble(scanner.nextLine());

        if ("diesel gasoline gas".contains(fuelType)) {
            if (fuelLeft >= 25) {
                System.out.printf("You have enough %s.", fuelType);
            } else {
                System.out.printf("Fill your tank with %s!", fuelType);
            }
        } else {
            System.out.println("Invalid fuel!");
        }
    }
}
