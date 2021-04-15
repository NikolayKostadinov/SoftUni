package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v2;

import java.util.Scanner;

public class P03WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tournamentPhase = scan.nextLine();
        String ticketKind = scan.nextLine();
        int ticketCount = Integer.parseInt(scan.nextLine());
        String trophyPicture = scan.nextLine();

        double price = 0;

        switch (tournamentPhase) {
            case "Quarter final":
                switch (ticketKind){
                    case "Standard":
                        price = 55.5;
                        break;
                    case "Premium":
                        price = 105.2;
                        break;
                    case "VIP":
                        price = 118.9;
                        break;
                }
                break;
            case "Semi final":
                switch (ticketKind){
                    case "Standard":
                        price = 75.88;
                        break;
                    case "Premium":
                        price = 125.22;
                        break;
                    case "VIP":
                        price = 300.4;
                        break;
                }
                break;
            case "Final":
                switch (ticketKind){
                    case "Standard":
                        price = 110.1;
                        break;
                    case "Premium":
                        price = 160.66;
                        break;
                    case "VIP":
                        price = 400;
                        break;
                }
                break;
        }

        double sum = ticketCount * price;
        if (sum > 4000){
            sum *= 0.75;
        } else {
            if (sum > 2500) sum *= 0.9;
            if ("Y".equals(trophyPicture)) sum += 40 * ticketCount;
        }

        System.out.printf("%.2f", sum);
    }
}
