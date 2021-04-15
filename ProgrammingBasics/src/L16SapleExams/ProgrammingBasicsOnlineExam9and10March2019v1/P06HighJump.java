package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v1;

import java.util.Scanner;

public class P06HighJump {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wantedHeight = Integer.parseInt(scan.nextLine());
        int currentHeight = wantedHeight - 30;
        int jumps = 0;
        while (currentHeight <= wantedHeight) {
            for (int i = 1; i <= 3; i++) {
                jumps++;
                if (Integer.parseInt(scan.nextLine()) > currentHeight) {
                    currentHeight += 5;
                    break;
                }

                if (i == 3) {
                    System.out.printf("Tihomir failed at %dcm after %d jumps.", currentHeight, jumps);
                    return;
                }
            }
        }

        System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", wantedHeight, jumps);
    }
}
