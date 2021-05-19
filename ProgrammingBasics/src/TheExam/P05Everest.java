package TheExam;

import java.util.Scanner;

public class P05Everest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        int everest = 8848;
        int claimed = 5364;
        int days = 1;
        while (!"END".equals(command)) {
            if ("Yes".equals(command)){
                days++;
                if (days > 5) break;
            }

            claimed += Integer.parseInt(scan.nextLine());
            if (claimed >= everest) {
                System.out.printf("Goal reached for %d days!", days);
                return;
            }
            command = scan.nextLine();
        }

        System.out.println("Failed!");
        System.out.println(claimed);
    }

}
