package L16SapleExams.ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class P04CinemaVoucher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int ticketCount = 0;
        int othersCount = 0;

        while(!"End".equals(command)){
            if (command.length() > 8){
                for (int i = 0; i < 2; i++) {
                    value -= command.charAt(i);
                }
                if (value >= 0) ticketCount++;
            }else{
                value -= command.charAt(0);
                if (value >= 0) othersCount++;
            }
                if (value < 0) break;
                command = scan.nextLine();
        }

        System.out.printf("%d\n%d", ticketCount, othersCount);
    }
}
