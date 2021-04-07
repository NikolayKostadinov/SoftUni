package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v2;

import java.util.Scanner;

public class P04TrekkingMania {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int groupCount = Integer.parseInt(scan.nextLine());
        int musalaCount = 0;
        int monblanCount = 0;
        int kilimanjaroCount = 0;
        int k2Count = 0;
        int everestCount = 0;
        int total = 0;

        for (int i = 0; i < groupCount; i++) {
            int count = Integer.parseInt(scan.nextLine());
            total += count;

            if (count <= 5) musalaCount += count;
            else if (6 <= count && count <= 12) monblanCount += count;
            else if (13 <= count && count <= 25) kilimanjaroCount += count;
            else if (26 <= count && count <= 40) k2Count += count;
            else if (count >= 40) everestCount += count;
        }

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n",
                (musalaCount / (double) total) * 100.0,
                (monblanCount / (double) total) * 100.0,
                (kilimanjaroCount / (double) total) * 100.0,
                (k2Count / (double) total) * 100.0,
                (everestCount / (double) total) * 100.0);
    }
}
