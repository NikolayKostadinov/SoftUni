package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019v2;

import java.util.Scanner;

public class P06MovieTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a1 = Integer.parseInt(scan.nextLine());
        int a2 = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        for (int p1 = a1; p1 < a2; p1++) {
            for (int p2 = 1; p2 < n; p2++) {
                for (int p3 = 1; p3 < n/2; p3++) {
                    if (p1 % 2 != 0 && (p2+p3+p1) % 2 != 0)
                    System.out.printf("%s-%d%d%d\n", (char)p1,p2,p3,p1);
                }
            }
        }
    }
}
