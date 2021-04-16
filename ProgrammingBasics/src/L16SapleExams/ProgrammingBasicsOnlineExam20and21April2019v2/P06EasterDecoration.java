package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v2;

import java.util.Scanner;

public class P06EasterDecoration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int clients = Integer.parseInt(scan.nextLine());
        double total = 0;
        for (int i = 0; i < clients; i++) {
            String command = scan.nextLine();
            int count = 0;
            double sum = 0;
            while (!"Finish".equals(command)) {
                count++;
                switch (command) {
                    case "basket":
                        sum += 1.5;
                        break;
                    case "wreath":
                        sum += 3.8;
                        break;
                    case "chocolate bunny":
                        sum += 7;
                        break;
                }
                command = scan.nextLine();
            }
            if (count % 2 == 0) sum *= 0.8;
            total += sum;
            System.out.printf("You purchased %d items for %.2f leva.\n", count, sum);
        }

        System.out.printf("Average bill per client is: %.2f leva.", total / (clients * 1.0));
    }
}
