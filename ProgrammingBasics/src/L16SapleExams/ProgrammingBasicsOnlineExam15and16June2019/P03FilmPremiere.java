package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class P03FilmPremiere {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movieName = scan.nextLine();
        String packageName = scan.nextLine();
        int tickets = Integer.parseInt(scan.nextLine());

        double ticketPrice = 0;

        switch (movieName) {
            case "John Wick":
                switch (packageName) {
                    case "Drink":
                        ticketPrice = 12;
                        break;
                    case "Popcorn":
                        ticketPrice = 15;
                        break;
                    case "Menu":
                        ticketPrice = 19;
                        break;
                }
                break;
            case "Star Wars":
                switch (packageName) {
                    case "Drink":
                        ticketPrice = 18;
                        break;
                    case "Popcorn":
                        ticketPrice = 25;
                        break;
                    case "Menu":
                        ticketPrice = 30;
                        break;
                }
                break;
            case "Jumanji":
                switch (packageName) {
                    case "Drink":
                        ticketPrice = 9;
                        break;
                    case "Popcorn":
                        ticketPrice = 11;
                        break;
                    case "Menu":
                        ticketPrice = 14;
                        break;
                }
                break;
        }

        if ("Star Wars".equals(movieName) && tickets >= 4) ticketPrice *= 0.7;
        if ("Jumanji".equals(movieName) && tickets == 2) ticketPrice *= 0.85;

        System.out.printf("Your bill is %.2f leva.", ticketPrice * tickets);
    }
}
