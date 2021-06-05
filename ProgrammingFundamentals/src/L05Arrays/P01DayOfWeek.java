package L05Arrays;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Scanner scan = new Scanner(System.in);
        int dayNumber = Integer.parseInt(scan.nextLine());
        if (1 > dayNumber || dayNumber > 7) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(days[dayNumber - 1]);
        }
    }
}
