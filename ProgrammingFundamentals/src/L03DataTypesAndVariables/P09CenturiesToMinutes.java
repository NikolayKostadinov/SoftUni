package L03DataTypesAndVariables;

import java.util.Scanner;

public class P09CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int centuries = Integer.parseInt(scan.nextLine());

        double years = centuries * 100;
        double days = years * 365.2422;
        double hours = 24 * days;
        double minutes = hours * 60;

        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes", centuries, years, days, hours, minutes);
    }
}
