package L08ConditionalStatementsAdvancedLab;

import java.util.Locale;
import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String month = scan.nextLine();
        int overnightCount = Integer.parseInt(scan.nextLine());

        double studioPrice = 0;
        double apartmentPrice = 0;

        switch (month.toLowerCase(Locale.ROOT)) {
            case ("may"):
            case ("october"):
                studioPrice = (overnightCount > 14) ? 50 * 0.7 :
                        (overnightCount > 7) ? 50 * 0.95 : 50;
                apartmentPrice = 65;
                break;
            case ("june"):
            case ("september"):
                studioPrice = (overnightCount > 14) ? 75.20 * 0.8 : 75.20;
                apartmentPrice = 68.7;
                break;
            case ("july"):
            case ("august"):
                studioPrice = 76;
                apartmentPrice = 77;
                break;
        }

        if (overnightCount > 14){
            apartmentPrice = apartmentPrice * 0.9;
        }

        System.out.printf("Apartment: %.2f lv.%n", apartmentPrice * overnightCount);
        System.out.printf("Studio: %.2f lv.", studioPrice * overnightCount);
    }
}
