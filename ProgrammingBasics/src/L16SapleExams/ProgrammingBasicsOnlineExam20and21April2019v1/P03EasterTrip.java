package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v1;

import java.util.Scanner;

public class P03EasterTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String country = scan.nextLine();
        String period = scan.nextLine();
        int overnightsCount = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (country) {
            case "France":
                switch (period){
                    case "21-23":
                        price = 30;
                        break;
                    case "24-27":
                        price = 35;
                        break;
                    case "28-31":
                        price = 40;
                        break;
                }
                break;
            case "Italy":
                switch (period){
                    case "21-23":
                        price = 28;
                        break;
                    case "24-27":
                        price = 32;
                        break;
                    case "28-31":
                        price = 39;
                        break;
                }
                break;
            case "Germany":
                switch (period){
                    case "21-23":
                        price = 32;
                        break;
                    case "24-27":
                        price = 37;
                        break;
                    case "28-31":
                        price = 43;
                        break;
                }
                break;
        }

        double sum = price * overnightsCount;

        System.out.printf("Easter trip to %s : %.2f leva.", country, sum);
    }
}
