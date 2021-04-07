package L16SapleExams.ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class P01OscarsCeremony {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rent = Integer.parseInt(scan.nextLine());
        double statues = rent * 0.7;
        double kettering = statues * 0.85;
        double music = kettering / 2.0;
        System.out.printf("%.2f", rent + statues + kettering + music);
    }
}
