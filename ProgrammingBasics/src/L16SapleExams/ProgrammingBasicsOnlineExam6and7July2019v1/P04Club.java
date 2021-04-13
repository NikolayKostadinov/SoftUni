package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v1;

import java.util.Scanner;

public class P04Club {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double wantedPrice = Double.parseDouble(scan.nextLine());
        String cocktailName = scan.nextLine();
        int count = 0;
        double sum = 0;
        int counter = 0;
        while (!"Party!".equals(cocktailName)) {
            count = Integer.parseInt(scan.nextLine());
            double bill =  cocktailName.length() * count;
            if (bill % 2 != 0) bill *= 0.75;
            sum += bill;

            if (sum >= wantedPrice) break;
            cocktailName = scan.nextLine();
        }

        if ("Party!".equals(cocktailName)){
            System.out.printf("We need %.2f leva more.\n", wantedPrice - sum);
        } else {
            System.out.println("Target acquired.");
        }
        System.out.printf("Club income - %.2f leva.", sum);
    }
}
