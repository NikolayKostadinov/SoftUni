package P06JavaConditionalStatementsMoreExercises;

import java.util.Locale;
import java.util.Scanner;

public class P08FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine().toLowerCase(Locale.ROOT);
        double fuelQuantity = Double.parseDouble(scanner.nextLine());
        String clubCrdOwner = scanner.nextLine().toLowerCase(Locale.ROOT);

        double price = 0.0;
        switch (fuelType) {
            case "gas":
                price = fuelQuantity * ((clubCrdOwner.equalsIgnoreCase("yes")) ? 0.93 - 0.08 : 0.93);
                break;
            case "gasoline":
                price = fuelQuantity * ((clubCrdOwner.equalsIgnoreCase("yes")) ? 2.22 - 0.18 : 2.22);
                break;
            default:
                price = fuelQuantity * ((clubCrdOwner.equalsIgnoreCase("yes")) ? 2.33 - 0.12 : 2.33);
                break;
        }

        double discount = 1;
        if (fuelQuantity >= 20 && fuelQuantity <= 25) {
            discount = 1 - 0.08;
        } else if (fuelQuantity > 25) {
            discount = 1 - 0.1;
        }

        System.out.printf("%.2f lv.", price * discount);

    }
}
