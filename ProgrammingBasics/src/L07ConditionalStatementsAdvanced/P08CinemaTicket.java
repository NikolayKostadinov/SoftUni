package L07ConditionalStatementsAdvanced;

import java.util.Locale;
import java.util.Scanner;

public class P08CinemaTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String day = scan.nextLine();

        int price = 0;

        switch (day.toLowerCase(Locale.ROOT)){
            case "monday":
            case "tuesday":
            case "friday":
                price = 12;
                break;
            case "wednesday":
            case "thursday":
                price = 14;
                break;
            default:
                price = 16;
        }

        System.out.println(price);
    }
}
