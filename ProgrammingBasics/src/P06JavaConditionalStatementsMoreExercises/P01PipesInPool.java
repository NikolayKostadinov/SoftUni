package P06JavaConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double poolVolume = Double.parseDouble(scan.nextLine());
        double flowP1 = Double.parseDouble(scan.nextLine());
        double flowP2 = Double.parseDouble(scan.nextLine());
        double hours = Double.parseDouble(scan.nextLine());

        double volumeP1 = flowP1 * hours;
        double volumeP2 = flowP2 * hours;
        double volume = volumeP1 + volumeP2;

        double volumeDifference = poolVolume - volume;
        double absoluteVolumeDifference = Math.abs(volumeDifference);

        if (volumeDifference >= 0) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.",
                    ((poolVolume - absoluteVolumeDifference) / poolVolume * 100),
                    (volumeP1 / volume * 100),
                    (volumeP2 / volume * 100));
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.",
                    hours, absoluteVolumeDifference);
        }

    }
}
