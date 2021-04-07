package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v2;

import java.util.Scanner;

public class P01SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int penPackages = Integer.parseInt(scan.nextLine());
        int markersPackages = Integer.parseInt(scan.nextLine());
        double cleaning = Double.parseDouble(scan.nextLine());
        int discount = Integer.parseInt(scan.nextLine());

        double sum = (penPackages * 5.80 + markersPackages * 7.2 + cleaning * 1.2) * (100 - discount ) / 100.0;

        System.out.printf("%.3f", sum);
    }
}
