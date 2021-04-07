package L16SapleExams.ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class P03OscarsWeekInCinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movieName = scan.nextLine();
        String hallType = scan.nextLine();
        int ticketsCount = Integer.parseInt(scan.nextLine());
        double ticketPrice = 0;
        switch (movieName){
            case "A Star Is Born":
                switch (hallType){
                    case "normal":
                        ticketPrice = 7.5;
                        break;
                    case "luxury":
                        ticketPrice = 10.5;
                        break;
                    case "ultra luxury":
                        ticketPrice = 13.5;
                        break;
                }
                break;
            case "Bohemian Rhapsody":
                switch (hallType){
                    case "normal":
                        ticketPrice = 7.35;
                        break;
                    case "luxury":
                        ticketPrice = 9.45;
                        break;
                    case "ultra luxury":
                        ticketPrice = 12.75;
                        break;
                }
                break;
            case "Green Book":
                switch (hallType){
                    case "normal":
                        ticketPrice = 8.15;
                        break;
                    case "luxury":
                        ticketPrice = 10.25;
                        break;
                    case "ultra luxury":
                        ticketPrice = 13.25;
                        break;
                }
                break;
            case "The Favourite":
                switch (hallType){
                    case "normal":
                        ticketPrice = 8.75;
                        break;
                    case "luxury":
                        ticketPrice = 11.55;
                        break;
                    case "ultra luxury":
                        ticketPrice = 13.95;
                        break;
                }
                break;
        }

        System.out.printf("%s -> %.2f lv.", movieName, ticketPrice * ticketsCount);
    }
}
