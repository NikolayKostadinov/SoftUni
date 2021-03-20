package L07ConditionalStatementsAdvancedLab;

import java.util.Locale;
import java.util.Scanner;

public class P13SkiTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        String roomType = scan.nextLine().toLowerCase(Locale.ROOT);
        String grade = scan.nextLine().toLowerCase(Locale.ROOT);

        double discount = 1;
        double roomPrice = 0;
        switch (roomType) {
            case "room for one person":
                roomPrice = 18.00;
                break;
            case "apartment":
                roomPrice = 25.00;
                discount = 0.7;
                if (days >= 10 && 15 >= days) {
                    discount = 0.65;
                } else if (days > 15) {
                    discount = 0.5;
                }
                break;
            case "president apartment":
                roomPrice = 35.00;
                discount = 0.9;
                if (days >= 10 && 15 >= days) {
                    discount = 0.85;
                } else if (days > 15) {
                    discount = 0.8;
                }
                break;
        }

        double price = roomPrice * discount * (days-1) * ("positive".equalsIgnoreCase(grade) ? 1.25 : 0.9);

        System.out.printf("%.2f", price);

    }
}
