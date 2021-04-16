package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v1;

import java.util.Scanner;

public class P01EasterLunch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer cakesCount = Integer.parseInt(scan.nextLine());
        Integer eggsPacketsCount = Integer.parseInt(scan.nextLine());
        Integer cookiesCount = Integer.parseInt(scan.nextLine());

        double sum = cakesCount * 3.2 + eggsPacketsCount * 4.35 + eggsPacketsCount * 12 * 0.15 + cookiesCount * 5.4;

        System.out.printf("%.2f", sum);
    }
}
