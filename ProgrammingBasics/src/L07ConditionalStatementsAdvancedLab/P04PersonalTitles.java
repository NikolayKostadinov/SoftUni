package L07ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P04PersonalTitles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double age = Double.parseDouble(scan.nextLine());
        String gender = scan.nextLine();

        String title = "";

        switch (gender){
            case "m":
                title = (age >= 16) ? "Mr." : "Master";
                break;
            case "f":
                title = (age >= 16) ? "Ms." : "Miss";
                break;
        }

        System.out.println(title);
    }
}
