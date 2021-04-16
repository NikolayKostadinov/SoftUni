package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v2;

import java.util.Scanner;

public class P01EasterBakery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double flourPrice = Double.parseDouble(scan.nextLine());
        double flourWeight = Double.parseDouble(scan.nextLine());
        double sugarWeight = Double.parseDouble(scan.nextLine());
        int eggsPackageCount = Integer.parseInt(scan.nextLine());
        int yeastCount = Integer.parseInt(scan.nextLine());

        double sugarPrice = flourPrice * 0.75;
        double eggsPrice = flourPrice * 1.1;
        double yeastPrice = sugarPrice * 0.2;

        double sum = flourPrice * flourWeight + sugarWeight * sugarPrice + eggsPackageCount * eggsPrice + yeastCount * yeastPrice;

        System.out.printf("%.2f", sum);

    }
}
