package L04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P05TrainingLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double roomWidth = Double.parseDouble(scan.nextLine());
        double roomHeight = Double.parseDouble(scan.nextLine());

        int rowsCount = (int) Math.floor (roomWidth / 1.2) ;
        int colsCount = (int) Math.floor ((roomHeight - 1) / 0.7) ;

        int deskCount = rowsCount * colsCount - 3;
        System.out.println(deskCount);
    }
}
