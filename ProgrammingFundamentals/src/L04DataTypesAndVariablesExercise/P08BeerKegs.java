package L04DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        double maxVolume = 0.0;
        String maxModel = "";

        for (int i = 0; i < n; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            double height = Double.parseDouble(scan.nextLine());

            double volume = Math.PI * Math.pow(radius,2) * height;

            if (volume >= maxVolume){
                maxVolume = volume;
                maxModel = model;
            }
        }

        System.out.println(maxModel);
    }
}
