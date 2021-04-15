package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v2;

import java.util.Scanner;

public class P04Darts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String field = scan.nextLine();

        int result = 301;
        int successfulCount = 0;
        int failedCount = 0;

        while (!"Retire".equals(field)) {
            int points = Integer.parseInt(scan.nextLine());
            switch (field) {
                case "Double":
                    points *= 2;
                    break;
                case "Triple":
                    points *= 3;
                    break;
            }
            if (points <= result) {
                result -= points;
                successfulCount++;

                if (result == 0) {
                    System.out.printf("%s won the leg with %d shots.", name, successfulCount);
                    return;
                }
            } else {
                failedCount++;
            }

            field = scan.nextLine();
        }

        System.out.printf("%s retired after %d unsuccessful shots.", name, failedCount);
    }
}
