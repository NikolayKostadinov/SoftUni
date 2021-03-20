package L07ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P04PersonalTitles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double age = Double.parseDouble(scan.nextLine());
        String sex = scan.nextLine();

        String title = "";

        if (sex.equalsIgnoreCase("m")) {
            title = (age >= 16) ? "Mr." : "Master";
        } else {
            title = (age >= 16) ? "Ms." : "Miss";
        }

        System.out.println(title);
    }
}
