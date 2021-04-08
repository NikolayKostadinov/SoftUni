package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v2;

import java.util.Scanner;

public class P03TravelAgency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String town = scan.nextLine();
        String packet = scan.nextLine();
        String isVIP = scan.nextLine();

        int days = Integer.parseInt(scan.nextLine());

        if (days < 1) {
            System.out.println("Days must be positive number!");
            return;
        }

        double price = 0;
        switch (town) {
            case "Bansko":
            case "Borovets":
                switch (packet) {
                    case "withEquipment":
                        price = 100;
                        if ("yes".equals(isVIP)) price *= 0.9;
                        break;
                    case "noEquipment":
                        price = 80;
                        if ("yes".equals(isVIP)) price *= 0.95;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        return;
                }
                break;
            case "Varna":
            case "Burgas":
                switch (packet) {
                    case "withBreakfast":
                        price = 130;
                        if ("yes".equals(isVIP)) price *= 0.88;
                        break;

                    case "noBreakfast":
                        price = 100;
                        if ("yes".equals(isVIP)) price *= 0.93;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        return;
                }
                break;
            default:
                System.out.println("Invalid input!");
                return;
        }

        if (days > 7 ) days--;
        System.out.printf("The price is %.2flv! Have a nice time!", price * days);
    }

}
