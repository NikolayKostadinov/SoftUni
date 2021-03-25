package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P08PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());

        if (((x == x1 || x == x2) && ((y1 <= y && y <= y2) || (y2 <= y && y <= y1)))
        || ((y == y1 || y == y2) && ((x1 <= x && x <= x2) || (x2 <= x && x <= x1)))){
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
