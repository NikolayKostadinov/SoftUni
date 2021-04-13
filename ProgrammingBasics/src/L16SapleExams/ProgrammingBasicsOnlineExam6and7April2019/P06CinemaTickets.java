package L16SapleExams.ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command= scan.nextLine();
        int student = 0;
        int standard = 0;
        int kids = 0;

        while(!"Finish".equals(command)){
            int freeSeats = Integer.parseInt(scan.nextLine());
            String type = scan.nextLine();
            int seedsTaken = 0;
            while(!"End".equals(type)){
                switch (type){
                    case "student":
                        student++;
                        break;
                    case "standard":
                        standard++;
                        break;
                    case "kid":
                        kids++;
                        break;
                }
                seedsTaken ++;
                if (freeSeats == seedsTaken) break;
                type = scan.nextLine();
            }

            System.out.printf("%s - %.2f%% full.\n", command, (seedsTaken / (double)freeSeats)* 100.0 );
            command = scan.nextLine();
        }

        int totalTickets = student + standard + kids;
        System.out.printf("Total tickets: %d\n", totalTickets);
        System.out.printf("%.2f%% student tickets.\n",  (student/(double)totalTickets) * 100.0);
        System.out.printf("%.2f%% standard tickets.\n",  (standard/(double)totalTickets) * 100.0);
        System.out.printf("%.2f%% kids tickets.\n",  (kids/(double)totalTickets) * 100.0);
    }
}
