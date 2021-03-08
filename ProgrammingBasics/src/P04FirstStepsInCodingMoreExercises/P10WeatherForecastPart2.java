package P04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P10WeatherForecastPart2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double temperature = Double.parseDouble(scan.nextLine());

        // 26.00 - 35.00	Hot
        // 20.1 - 25.9	    Warm
        //  15.00 - 20.00	Mild
        //  12.00 - 14.9	Cool
        //  5.00 - 11.9	    Cold
        String weather = "";

        if (temperature >= 26.0 && temperature <= 35.00){
            weather = "Hot";
        }else if (temperature >= 20.1 && temperature <= 25.9){
            weather = "Warm";
        }else if (temperature >= 15.0 && temperature <= 20.0){
            weather = "Mild";
        }else if (temperature >= 12.0 && temperature <= 14.9){
            weather = "Cool";
        }else if (temperature >= 5.00 && temperature <= 11.9){
            weather = "Cold";
        } else {
            weather = "unknown";
        }

        System.out.println(weather);
    }
}
