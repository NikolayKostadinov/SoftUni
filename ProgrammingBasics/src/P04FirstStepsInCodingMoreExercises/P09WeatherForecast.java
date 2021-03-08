package P04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P09WeatherForecast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String weather = scan.nextLine();

        if (weather.equalsIgnoreCase("sunny")){
            System.out.println("It's warm outside!");
        } else {
            System.out.println("It's cold outside!");
        }
    }
}
