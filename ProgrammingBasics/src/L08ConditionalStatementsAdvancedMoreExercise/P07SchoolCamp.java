package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P07SchoolCamp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String season = scan.nextLine();
        String groupGender = scan.nextLine();
        int studentsCount = Integer.parseInt(scan.nextLine());
        int overnightCount = Integer.parseInt(scan.nextLine());

        double price = 0;
        String sport = "";

        switch (season){
            case "Winter":
                price = 9.6;
                switch (groupGender){
                    case "girls":
                        sport = "Gymnastics";
                        break;
                    case "boys":
                        sport = "Judo";
                        break;
                    case "mixed":
                        sport = "Ski";
                        price = 10.0;
                        break;
                }
                break;
            case "Spring":
                price = 7.2;
                switch (groupGender){
                    case "girls":
                        sport = "Athletics";
                        break;
                    case "boys":
                        sport = "Tennis";
                        break;
                    case "mixed":
                        sport = "Cycling";
                        price = 9.5;
                        break;
                }
                break;
            case "Summer":
                price = 15;
                switch (groupGender){
                    case "girls":
                        sport = "Volleyball";
                        break;
                    case "boys":
                        sport = "Football";
                        break;
                    case "mixed":
                        sport = "Swimming";
                        price = 20;
                        break;
                }
                break;
        }

        double discount = 1;

        if (studentsCount >= 50){
            discount = 0.5;
        } else if (20 <= studentsCount && studentsCount < 50) {
            discount = 0.85;
        } else if (10 <= studentsCount && studentsCount < 20) {
            discount = 0.95;
        }

        System.out.printf("%s %.2f lv.", sport, price * studentsCount * overnightCount * discount);
    }
}
