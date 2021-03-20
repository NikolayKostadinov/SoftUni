package L06ConditionalStatementsExercise;

import java.util.Scanner;

public class P04MetricConverter {
    public static void main(String[] args) {
        String mm = "mm";
        String cm = "cm";
        String m = "m";

        Scanner scan = new Scanner(System.in);
        double distance = Double.parseDouble(scan.nextLine());
        String sourceMeasurement = scan.nextLine();
        String targetMeasurement = scan.nextLine();

        double result = 0;

        if (sourceMeasurement.equalsIgnoreCase(targetMeasurement)){
            result = distance;
        } else if(sourceMeasurement.equalsIgnoreCase(mm) && targetMeasurement.equalsIgnoreCase(cm)){
            result = distance / 10.0;
        }else if(sourceMeasurement.equalsIgnoreCase(mm) && targetMeasurement.equalsIgnoreCase(m)){
            result = distance / 1000.0;
        }else if(sourceMeasurement.equalsIgnoreCase(cm) && targetMeasurement.equalsIgnoreCase(mm)){
            result = distance * 10.0;
        }else if(sourceMeasurement.equalsIgnoreCase(cm) && targetMeasurement.equalsIgnoreCase(m)){
            result = distance / 100.0;
        }else if(sourceMeasurement.equalsIgnoreCase(m) && targetMeasurement.equalsIgnoreCase(mm)){
            result = distance * 1000.0;
        }else if(sourceMeasurement.equalsIgnoreCase(m) && targetMeasurement.equalsIgnoreCase(cm)){
            result = distance * 100.0;
        }

        System.out.printf("%.3f", result);

    }
}
