package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P05Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        String location = "";
        String place = "";
        double vacationPrice = 0;

        if(season.equalsIgnoreCase("summer")){
            location = "Alaska";
        }else{
            location = "Morocco";
        }

        if (budget<=1000){
            place = "Camp";
            vacationPrice = budget * ((season.equalsIgnoreCase("summer")) ? 0.65 : 0.45);
        } else if (1000 < budget && budget <= 3000) {
            place = "Hut";
            vacationPrice = budget * ((season.equalsIgnoreCase("summer")) ? 0.80 : 0.6);
        } else if (budget > 3000){
            place = "Hotel";
            vacationPrice = budget * 0.90;
        }

        System.out.printf("%s - %s - %.2f", location, place, vacationPrice);
    }
}
