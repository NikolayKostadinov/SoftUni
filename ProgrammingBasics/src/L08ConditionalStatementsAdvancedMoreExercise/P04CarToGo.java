package L08ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class P04CarToGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        String carClass = "";
        String carType = "";
        double carPrice = 0;

        if (budget<=100){
            carClass = "Economy class";
            if(season.equalsIgnoreCase("summer")){
                carType = "Cabrio";
                carPrice = budget * 0.35;
            }else{
                carType = "Jeep";
                carPrice = budget * 0.65;
            }
        } else if (100 < budget && budget <= 500) {
            carClass = "Compact class";
            if(season.equalsIgnoreCase("summer")){
                carType = "Cabrio";
                carPrice = budget * 0.45;
            }else{
                carType = "Jeep";
                carPrice = budget * 0.80;
            }
        } else if (budget > 500){
            carClass = "Luxury class";
            carType = "Jeep";
            carPrice = budget * 0.90;
        }

        System.out.printf("%s\n%s - %.2f", carClass, carType, carPrice);
    }
}
