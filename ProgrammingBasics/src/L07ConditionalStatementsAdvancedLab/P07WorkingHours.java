package L07ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P07WorkingHours {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = Integer.parseInt(scan.nextLine());
        String day = scan.nextLine();

        System.out.println((!day.equalsIgnoreCase("Sunday") && 10 <= hour && hour <= 18) ? "open" : "closed");
    }
}
